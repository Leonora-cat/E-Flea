package cpt202.bughunter.eflea.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Date;

@Data
@NoArgsConstructor
public class Product {

    private Long PID;
    private String UID;
    private String name;
    private Double price;

    private String tag;

    private String description;

    private String lifeTime;
    private Boolean state = false;

    private Date date;

    private byte[] image1;
    private byte[] image2;
    private byte[] image3;


    public static String convertBlobToBase64String(Blob blob) {
        String result = "";
        if(null != blob) {
            try {
                InputStream msgContent = blob.getBinaryStream();
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                byte[] buffer = new byte[100];
                int n = 0;
                while (-1 != (n = msgContent.read(buffer))) {
                    output.write(buffer, 0, n);
                }
                result =new BASE64Encoder().encode(output.toByteArray()) ;
                output.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }else {
            return null;
        }
    }
}