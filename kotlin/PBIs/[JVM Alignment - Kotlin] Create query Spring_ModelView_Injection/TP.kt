import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

@Controller
class MyController {
    
    @GetMapping("/myview")
    fun myView(@RequestParam input: String): ModelAndView {
        val mav = ModelAndView(input)
        return mav
    }

    @GetMapping("/test4")
    fun test4(@RequestParam input: String): ModelAndView {
        val model = ModelAndView()
        model.modelMap["test4_attr1"] = "mapping method-level attribute added using kt shortcut"
        model.addObject("test4_attr2","mapping method-level attribute added using addObject()")
        val myMap1 = HashMap<String, String>()
        myMap1.put("map4_attr1","first mapping-level attribute added using addAllObjects(Map)")
        myMap1["map4_attr2"] = "second mapping-level attribute added using addAllObjects(Map)"
        model.addAllObjects(myMap1)
        model.setViewName(input)
        return model
    }
    
}