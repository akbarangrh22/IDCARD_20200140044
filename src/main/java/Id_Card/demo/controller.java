/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Id_Card.demo;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */
@Controller
public class controller {
    @RequestMapping("/login")
    public String next(@RequestParam (value="inputuser") String getUsernama,
                           @RequestParam (value="inputdate") String getDate,
                           @RequestParam (value="inputreligion") String getReligion,
                           @RequestParam (value="inputjob") String  getJob,
                           @RequestParam (value="inputfoto") MultipartFile getFoto,                         
                           Model model)
    throws IOException{
        byte[] img = getFoto.getBytes();
        String base64Image = Base64.encodeBase64String(img);
        String imglink ="data:image/png;base64,".concat(base64Image);
        model.addAttribute("kirimanUser", getUsernama);
        model.addAttribute("kirimanDate", getDate);
        model.addAttribute("kirimanReligion", getReligion);
        model.addAttribute("kirimanJob", getJob);
        model.addAttribute("kirimanFoto", imglink);
        return "main";
    }
            
    
}
