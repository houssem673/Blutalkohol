package propra.woche3;


import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

@Controller
@SessionAttributes({"alkoholform"})  //Session versuch zu verwenden
public class BlutalkoholwertController {
@GetMapping("/")
public String base(Model model){
    model.addAttribute("alkoholform",new AlkoholForm());
    return "base";
}
@PostMapping("/calculate")
public String calculate( Model model, @Valid AlkoholForm alkoholform,BindingResult bindingResult){
    model.addAttribute("alkoholform",alkoholform);
    model.addAttribute("geschlecht",alkoholform.getGeschlecht());
    model.addAttribute("gewicht",alkoholform.getGewicht());

    if (bindingResult.hasErrors())
        return "calculate";

return "result";
}
@PostMapping("/result")
public String result(Model model , @Valid @ModelAttribute("alkoholform") AlkoholForm alkoholform, BindingResult bindingResult) {
    double ergebnis = 0;
    String geschlecht = alkoholform.getGeschlecht();
      // geschlecht ist immer null + nach Debugging alle Attribute in alkoholform haben den Wert Null ??????
       if (geschlecht != null) {
           if ("Mann".equals(alkoholform.getGeschlecht())) {
               ergebnis = (alkoholform.getBier() + alkoholform.getKorn() + alkoholform.getWein()
                       + alkoholform.getVodka() + alkoholform.getWhiskey()) / alkoholform.getGewicht() * 0.7;
           } else {
               ergebnis = (alkoholform.getBier() + alkoholform.getKorn() + alkoholform.getWein()
                       + alkoholform.getVodka() + alkoholform.getWhiskey()) / alkoholform.getGewicht() * 0.6;
           }
       }
    model.addAttribute("ergebnis", ergebnis);
    model.addAttribute("alkoholform", alkoholform);

    if (bindingResult.hasErrors()) {
        return "result";
    }
    return "result";
}
}
