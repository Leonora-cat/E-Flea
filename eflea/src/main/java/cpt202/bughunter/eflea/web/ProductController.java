package cpt202.bughunter.eflea.web;

import com.github.pagehelper.PageInfo;
import cpt202.bughunter.eflea.domain.Product;
import cpt202.bughunter.eflea.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Api(tags = "productController")
@RestController
@RequestMapping(value = "/products")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;


    static Map<String, Product> products = Collections.synchronizedMap(new HashMap<String, Product>());


    /**
     * get product list
     */
    @GetMapping("/")
    @ApiOperation(value = "show info on product page", notes = "one picture per product")
    public List<List<Product>> getProductImage() {
        List<Product> tag1 = productService.displayAll("Clothes");
        List<Product> tag2 = productService.displayAll("Fitness equipment");
        List<Product> tag3 = productService.displayAll("Device");
        List<Product> tag4 = productService.displayAll("Supplies");

        List<List<Product>> productByTag = new ArrayList<>();
        productByTag.add(tag1);
        productByTag.add(tag2);
        productByTag.add(tag3);
        productByTag.add(tag4);
        return productByTag;
    }


    /**
     * return all products of a user
     *
     * @param
     */
    @GetMapping("/{name}/pages")
    @ApiOperation(value = "get all of the products of the user", notes = "")
    public List<Product> userProduct(@PathVariable String name) {
        return productService.allProduct();
    }

    //selling and sold
    @GetMapping("/{name}/selling")
    @ApiOperation(value = "sold", notes = "")
    public List<Product> selling(@PathVariable String name) {
        return productService.selling(name);
    }

    @GetMapping("/{name}/sold")
    @ApiOperation(value = "selling", notes = "")
    public List<Product> sold(@PathVariable String name) {
        return productService.sold(name);
    }


    @GetMapping("/{name}/pages/price")
    @ApiOperation(value = "return all products order by price", notes = "")
    public List<Product> displayProductByPrice(@PathVariable String name) {
        return productService.displayProductByPrice();
    }

    //
    @GetMapping("/{tag}")
    @ApiOperation(value = "return all products with the same key", notes = "")
    public List<Product> tag(@PathVariable String tag) {
        return productService.findByTag(tag);
    }

    @PostMapping("/{name}/search")
    @ApiOperation(value = "search", notes = "")
    public List<Product> search(@RequestBody String key, @PathVariable String name) {

        key = key.substring(0, key.length() - 1);
        key = "%" + key + "%";
        System.out.println(key);
        return productService.search(key, name);
    }

    @PostMapping("/{name}/searchAll")
    @ApiOperation(value = "global search", notes = "")
    public List<Product> searchAll(@RequestBody String key) {

        key = key.substring(0, key.length() - 1);
        key = "%" + key + "%";
        System.out.println(key);
        return productService.searchAll(key);
    }

    /**
     * deal with "/products/add" PUT request，add product
     *
     * @param product
     */
    @PutMapping("/upload")
    @ApiOperation(value = "add product", notes = "receive a json data")
    public Long uploadProduct(@RequestBody Product product) {

        try {
            product.setDate(new Date());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date1 = df.format(product.getDate());
            product.setDate(df.parse(date1));
            productService.insert(product.getPID(), product.getName(), product.getPrice(), product.getTag(),
                    product.getLifeTime(), product.getDescription(), product.getUID(), product.getState(), product.getDate());
        } catch (Exception e) {
            //返回错误信息
            e.printStackTrace();
        }

        return productService.findProductByPName(product.getName()).getPID();
    }

    @GetMapping("/{name}/{pname}")
    @ApiOperation(value = "single item", notes = "")
    public Product item(@PathVariable String pname) {
        return productService.findProductByPName(pname);
    }

    /**
     * deal with "/products/update/{id}" PUT request，update product
     */
    @PutMapping("/update{id}")
    @ApiOperation(value = "update product info", notes = "")
    public String updateProduct(@PathVariable Long id, @RequestBody Product product) {

        try {
            productService.update(id, product.getPrice(), product.getLifeTime(),
                    product.getDescription());
        } catch (Exception e) {

            e.printStackTrace();
            return ("error");
        }
        return "success";
    }

    @PutMapping("/updateState")
    @ApiOperation(value = "update product status", notes = "change from selling to sold")
    public String updateState(@RequestBody Product product) {
        try {
            productService.updateState(product.getState(), product.getPID());
        } catch (Exception e) {

            e.printStackTrace();
            return ("error");
        }
        return "success";
    }

    /**
     * delete product
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete product")
    public String deleteUser(@PathVariable Long id) {
        try {
            productService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    @PostMapping("/uploadImage{id}")
    @ResponseBody
    @ApiOperation(value = "upload images", notes = "3 images exactly")
    public String savePic(@RequestPart MultipartFile[] images, @PathVariable Long id) throws IOException {
        MultipartFile image1 = images[0];
        MultipartFile image2 = images[1];
        MultipartFile image3 = images[2];
        if (image1.isEmpty()) {
            return "image1 fail";
        }
        if (image3.isEmpty()) {
            return "image3 fail";
        }
        if (image2.isEmpty()) {
            return "image2 fail";
        }


        InputStream is1 = image1.getInputStream();
        InputStream is2 = image2.getInputStream();
        InputStream is3 = image3.getInputStream();
        byte[] pic1 = new byte[(int) image1.getSize()];
        byte[] pic2 = new byte[(int) image1.getSize()];
        byte[] pic3 = new byte[(int) image1.getSize()];

        is1.read(pic1);
        is2.read(pic2);
        is3.read(pic3);

        try {
            productService.insertImage(pic1, pic2, pic3, id);
        } catch (Exception e) {
            e.printStackTrace();

        }


        return "success";
    }
    @GetMapping("/getTotalSellingNum")
    @ApiOperation(value="getTotalSellingNum", notes="get total selling number")
    public Map<String, Integer> getTotalSellingNum(){
        int totalNum = productService.getTotalSellingNum();
        Map<String, Integer> totalNumber = new HashMap<>();
        totalNumber.put("totalNum",totalNum);
        return totalNumber;
    }

    @GetMapping("/getTotalSoldNum")
    @ApiOperation(value="getTotalSoldNum", notes="get total sold number")
    public Map<String, Integer> getTotalSoldNum(){
        int totalNum = productService.getTotalSoldNum();
        Map<String, Integer> totalNumber = new HashMap<>();
        totalNumber.put("totalNum",totalNum);
        return totalNumber;
    }


}