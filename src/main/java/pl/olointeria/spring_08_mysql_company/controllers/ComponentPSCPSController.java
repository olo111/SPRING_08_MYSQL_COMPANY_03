package pl.olointeria.spring_08_mysql_company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.olointeria.spring_08_mysql_company.component.ComponentPSCPS;
import pl.olointeria.spring_08_mysql_company.component.ComponentPSCPSRepository;
import pl.olointeria.spring_08_mysql_company.prima.SupplierRepository;
import pl.olointeria.spring_08_mysql_company.prima.Supplier;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


@Controller
public class ComponentPSCPSController {

    @Autowired
    private ComponentPSCPSRepository componentPSCPSRepo;
    @Autowired
    private SupplierRepository supplierRepository;

    @GetMapping("/componentsPSCPS/new")
    public  String showProductsForm(Model model){
        List<Supplier> listSuppliers = supplierRepository.findAll();
        model.addAttribute("product", new ComponentPSCPS());
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
    @GetMapping("/components_PSCPS")
    public  String showListPSCPSComponents(Model model){
        List<ComponentPSCPS> listPSCPSComponents =componentPSCPSRepo.findAll();

        model.addAttribute("listPSCPSComponents", listPSCPSComponents);
        return "components_PSCPS";
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

@GetMapping("/search_component")
String home() {
return "component/search_component";
}


@PostMapping("/components_PSCPS_BySapNumber")
//@ResponseBody
    public  String components_PSCPS_BySapNumber(String sapNumber,String customer,Model model){
    System.out.println("To jest sapNumber przekazany:  "+ sapNumber);
    System.out.println("To jest customer przekazany:  "+ customer);



// case #1 sap =" "  i customer=" "
    if(sapNumber.isEmpty()&&customer.isEmpty()){
        System.out.println("WARUNEK  SPEŁNIONY: customer= PUSTY  i  sapNumber =  PUSTY ");

    }else {
        System.out.println("WARUNEK #1 sapNumber.isEmpty()&&customer.isEmpty()  -- NIE SPEŁNIONY: customer= PUSTY  i  sapNumber =PUSTY");
    }
// case #2 sap =" "  lub customer=NIE " "

    if(sapNumber.isEmpty()||!customer.isEmpty()){
        List<ComponentPSCPS> listComponentsPSCPSWhith_Customer = componentPSCPSRepo.findAll();
        List<ComponentPSCPS> listaPSCPSbyCustomer = nowalistaPSCPSByCustmer(listComponentsPSCPSWhith_Customer, customer );
        model.addAttribute("listPSCPSComponents", listaPSCPSbyCustomer);
        model.addAttribute("customer", customer);
        

    }else {
        System.out.println("WARUNEK #2  sapNumber.isEmpty()||!customer.isEmpty()  --    NIE SPEŁNIONY: customer= PUSTY  lub  sapNumber = NIEPUSTY ");
    }

// case #3 sap  =  NIE " "  lub  customer=" "

    if(customer.isEmpty()||!sapNumber.isEmpty()){
         List<ComponentPSCPS> listComponentsPSCPSWhith_sapNumber = componentPSCPSRepo.findAll();
		List<ComponentPSCPS> listaPSCPS = nowalistaPSCPS(listComponentsPSCPSWhith_sapNumber, sapNumber );
        model.addAttribute("listPSCPSComponents", listaPSCPS);
        model.addAttribute("sapNumber", sapNumber);
       
    }
    else {
        System.out.println("WARUNEK #3 customer.isEmpty()||!sapNumber.isEmpty()-- NIE SPEŁNIONY: customer= NIEPUSTY  lub  sapNumber =PUSTY ");
    }
    
    // case #4 sap  =  NIE " "  lub  customer=NIE" "

    if(!customer.isEmpty()&&!sapNumber.isEmpty()){
        List<ComponentPSCPS> listComponentsPSCPSWhith_sapNumber = componentPSCPSRepo.findAll();
       List<ComponentPSCPS> listaPSCPS = nowalistaPSCPS(listComponentsPSCPSWhith_sapNumber, sapNumber );
       List<ComponentPSCPS> listaPSCPSbyCustomer = nowalistaPSCPSByCustmer(listComponentsPSCPSWhith_sapNumber, customer );
       model.addAttribute("listaPSCPSbyCustomer", listaPSCPSbyCustomer);
       model.addAttribute("listPSCPSComponents", listaPSCPS);
       model.addAttribute("sapNumber", sapNumber);
       model.addAttribute("customer", customer);
       
   }
   else {
       System.out.println("WARUNEK #4 !customer.isEmpty()&&!sapNumber.isEmpty()  --  NIE SPEŁNIONY: customer= NIEPUSTY  i  sapNumber =NIEPUSTY ");
   }
    
    //model.addAttribute("listPSCPSComponents", listaPSCPS);
    System.out.println("To jest customer:  "+ customer);
    System.out.println("To jest SapNumber:  "+ sapNumber);
    return "component/components_PSCPS_SapNumber";
    }
    
    private List<ComponentPSCPS> nowalistaPSCPS(List<ComponentPSCPS> lista, String sapNumber) {
        List<ComponentPSCPS> listaPSCPS =new ArrayList<>();
       
        for (ComponentPSCPS component:lista
        ) {
           String sapNumber2= component.getSapNumber();
           // System.out.println("To jest SapNumberdla componentu z listy repo:  "+ sapNumber2);
           // System.out.println("To jest SapNumber szukany:  "+sapNumber);
            if (sapNumber2.equals(sapNumber)){
                int i=1;i++;
               // System.out.println("czemu to jest wykonane:   "+i);
                //System.out.println("To jest id_sap: "+sapNumber);
              listaPSCPS.add(component);
           }
//
           // System.out.println("Nowa ListComponents:  "+listaPSCPS);
        }
      //  System.out.println("Nowa ListComponents_2:  "+listaPSCPS);
        return listaPSCPS;
    }

    private List<ComponentPSCPS> nowalistaPSCPSByCustmer(List<ComponentPSCPS> lista, String customer) {
        List<ComponentPSCPS> listaPSCPSbyCustomer =new ArrayList<>();
       
        ;
        for (ComponentPSCPS component:lista
        ) {
           
        String customer2 = component.getCustomer();
           // System.out.println("To jest customer2 dla componentu z listy repo:  "+ customer2);
           // System.out.println("To jest customer szukany:  "+customer);
            int i=1;
            if (customer2.equals(customer)){
                i++;
               // System.out.println("czemu to jest wykonane:   "+i);
              //  System.out.println("To jest customer: "+customer);
                listaPSCPSbyCustomer.add(component);
           }
//
           // System.out.println("Nowa ListComponents:  "+listaPSCPS);
        }
       // System.out.println("Nowa ListComponents_2:  "+listaPSCPSbyCustomer.toString());
        return listaPSCPSbyCustomer;
    }
}
