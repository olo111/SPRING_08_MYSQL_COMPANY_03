package pl.olointeria.spring_08_mysql_company.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.olointeria.spring_08_mysql_company.prima.SupplierRepository;
import pl.olointeria.spring_08_mysql_company.prima.Supplier;


import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@Controller
public class ComponentController {

    @Autowired
    private ComponentRepository componentRepo;
    @Autowired
    private SupplierRepository supplierRepository;

    @GetMapping("/components/new")
    public  String showProductsForm(Model model){
        List<Supplier> listSuppliers = supplierRepository.findAll();
        model.addAttribute("product", new Component());
       model.addAttribute("listSuppliers", listSuppliers);
        return "product_form";
    }

//    @PostMapping("/components/save")
//    public  String saveProducts(Component product, HttpServletRequest request){
//        String[] detailIDs = request.getParameterValues("detailID");
//        String[] detailNames = request.getParameterValues("detailName");
//        String[] detailValues = request.getParameterValues("detailValue");
//            for(int i=0 ; i < detailNames.length ; i++){
//                if (detailIDs != null && detailIDs.length > 0) {
//                    product.setDetail(Integer.valueOf(detailIDs[i]),detailNames[i], detailValues[i]);
//                }  else {
//
//                        product.addDetail(detailNames[i], detailValues[i]);
//                    }
//                }
//        productRepo.save(product);
//
//        return "redirect:/components";
//    }
    @GetMapping("/components")
    public  String showListComponents(Model model){
        List<Component> listComponents =componentRepo.findAll();

        model.addAttribute("listComponents", listComponents);
        return "components";
    }

//    @GetMapping("/components/delete/{id}")
//    public  String deleteProductById(@PathVariable("id") Integer id, Model model){
//        componentRepo.deleteById(id);
//        List<Category> listCategories =categoryRepository.findAll();
//        // model.addAttribute("product", new Product());
//
//        model.addAttribute("listCategories", listCategories);
//
//
//        return "redirect:/components";
//    }
//    @GetMapping("/products/find/{name}")
//    public  String findProductByName(@PathVariable("name") Product product, Model model){
//        productRepo.findAll((Pageable) product);
//        List<Category> listCategories =categoryRepository.findAll();
//        // model.addAttribute("product", new Product());
//
//        model.addAttribute("listCategories", listCategories);
//
//
//        return "redirect:/products";
//    }
}
