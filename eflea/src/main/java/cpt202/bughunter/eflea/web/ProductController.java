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

@Api(tags = "商品管理")
@RestController
@RequestMapping(value = "/products")     // 通过这里配置使下面的映射都在/products下
@CrossOrigin
public class ProductController {

    // 创建线程安全的Map，模拟products信息的存储


    @Autowired
    private ProductService productService;


    static Map<String, Product> products = Collections.synchronizedMap(new HashMap<String, Product>());


    /**
     * 处理"/products/"的GET请求，用来获取商品列表
     *
     *
     */
    @GetMapping("/")
    @ApiOperation(value = "首页展示部分图片", notes = "每个商品展示一张图片")
    public List<List<Product>> getProductImage() {
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        List<Product> tag1 = productService.displayAll("1");
        List<Product> tag2 = productService.displayAll("2");
        List<Product> tag3 = productService.displayAll("3");
        List<Product> tag4 = productService.displayAll("4");

        List<List<Product>> productByTag = new ArrayList<>();
        productByTag.add(tag1);
        productByTag.add(tag2);
        productByTag.add(tag3);
        productByTag.add(tag4);
        return productByTag;
    }



    /**
     * 处理"/{name}/pages"的GET
     *返回该用户所有商品
     * @param
     *
     */
    @GetMapping("/{name}/pages")
    @ApiOperation(value = "返回该用户所有商品", notes = "")
    public List<Product> userProduct(@PathVariable String name){
        return productService.allProduct();
    }

    //selling and sold
    @GetMapping("/{name}/selling")
    @ApiOperation(value = "sold", notes = "")
    public List<Product> selling(@PathVariable String name){
        return productService.selling(name);
    }
    @GetMapping("/{name}/sold")
    @ApiOperation(value = "selling", notes = "")
    public List<Product> sold(@PathVariable String name){
        return productService.sold(name);
    }
    /**
     * 处理"/"的GET
     *返回该用户所有商品
     * @param
     *
     */
    @GetMapping("/{tag}")
    @ApiOperation(value = "返回该类型所有商品", notes = "")
    public List<Product> tag(@PathVariable String tag){
        return productService.findByTag(tag);
    }

    /**
     * 处理"/{name}/search"的GET
     *返回该用户所有商品
     * @param
     *
     */
    @PostMapping("/{name}/search")
    @ApiOperation(value = "搜索", notes = "")
    public List<Product> search(@RequestBody String key, @PathVariable String name){

        key = key.substring(0,key.length() - 1);
        key = "%"+ key +"%";
        System.out.println(key);
        return productService.search(key, name);
    }

    /**
     * 处理"/{name}/search"的GET
     *返回该用户所有商品
     * @param
     *
     */
    @PostMapping("/{name}/searchAll")
    @ApiOperation(value = "全局搜索", notes = "")
    public List<Product> searchAll(@RequestBody String key){

        key = key.substring(0,key.length() - 1);
        key = "%"+ key +"%";
        System.out.println(key);
        return productService.searchAll(key);
    }

    /**
     * 处理"/products/add"的PUT请求，用来添加product
     *接受id和product对象，添加进数据库
     * @param product
     *
     */
    @PutMapping("/upload")
    @ApiOperation(value = "添加商品", notes = "接受前端json数据，存入数据库")
    public Long uploadProduct(@RequestBody Product product) {

        try{
            product.setDate(new Date());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date1 = df.format(product.getDate());
            product.setDate(df.parse(date1));
            productService.insert(product.getPID(), product.getName(), product.getPrice(), product.getTag(),
                    product.getLifeTime(), product.getDescription(), product.getUID(), product.getState(), product.getDate());
        }catch (Exception e) {
            //返回错误信息
            e.printStackTrace();
        }

        return productService.findProductByPName(product.getName()).getPID();
    }
    /**
     * 处理"/"的GET
     *返回该用户所有商品
     * @param
     *
     */
    @GetMapping("/{name}/{pname}")
    @ApiOperation(value = "single item", notes = "")
    public Product item(@PathVariable String pname){
        return productService.findProductByPName(pname);
    }

    /**
     * 处理"/products/update/{id}"的PUT请求，用来更新product信息
     *接受id和product对象，添加进数据库
     * @param id
     * @param product
     * @return
     */
    @PutMapping("/update{id}")
    @ApiOperation(value = "更新商品信息", notes = "接受前端json数据，更新数据库")
    public String updateProduct(@PathVariable Long id, @RequestBody Product product) {

            try{
                productService.update(id, product.getPrice(),  product.getLifeTime(),
                        product.getDescription());
            }catch (Exception e) {
                //返回错误信息
                e.printStackTrace();
                return("error");
            }
        return "success";
    }

    /**
     * 处理"/products/{id}"的DELETE请求，用来删除product
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除商品")
    public String deleteUser(@PathVariable Long id) {
        try{
            productService.delete(id);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    /**
     * 处理"/products/uploadImage"的DELETE请求，用来删除product
     *
     * @param   id, images
     * @return
     */
    @PostMapping("/uploadImage{id}")
    @ResponseBody
    @ApiOperation(value = "上传商品图片", notes = "3 images exactly")
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
        byte[] pic1 = new byte[(int)image1.getSize()];
        byte[] pic2 = new byte[(int)image1.getSize()];
        byte[] pic3 = new byte[(int)image1.getSize()];

        is1.read(pic1);
        is2.read(pic2);
        is3.read(pic3);

        try{
            productService.insertImage(pic1, pic2, pic3, id);
        } catch (Exception e) {
            e.printStackTrace();

        }


        return "success";
    }

}
