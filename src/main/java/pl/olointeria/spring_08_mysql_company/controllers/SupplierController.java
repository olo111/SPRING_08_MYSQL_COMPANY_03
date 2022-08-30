package pl.olointeria.spring_08_mysql_company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.olointeria.spring_08_mysql_company.component.ComponentPSCPS;
import pl.olointeria.spring_08_mysql_company.component.Component;
import pl.olointeria.spring_08_mysql_company.component.ComponentPSAPT;
import pl.olointeria.spring_08_mysql_company.component.ComponentPSCPSRepository;
import pl.olointeria.spring_08_mysql_company.component.ComponentPSAPTRepository;
import pl.olointeria.spring_08_mysql_company.component.ComponentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import pl.olointeria.spring_08_mysql_company.prima.SupClassification;
import pl.olointeria.spring_08_mysql_company.prima.Supplier;
import pl.olointeria.spring_08_mysql_company.prima.SupplierRepository;

import javax.xml.XMLConstants;
//@RestController
@Controller
public class SupplierController {
    @Autowired

    private SupplierRepository repo;
    @Autowired
    private ComponentPSCPSRepository  componentPSCPSRepo;
    
    @Autowired
    private ComponentPSAPTRepository  componentPSAPTRepo;
    
    @Autowired
    private ComponentRepository  componentRepo;
    
  // public SupplierController(ComponentRepository componentRepo) {
   //    this.componentRepo = componentRepo;
  // }
    @GetMapping("/home")
    String home() {
        //ewentualna logika metody
        return "index.html"; //nazwa pliku w katalogu /templates
    }
//    @PostMapping ("/")
//    String home2() {
//        //ewentualna logika metody
//        return "index.html"; //nazwa pliku w katalogu /templates
//    }

    @GetMapping("/suppliers")
    public String listSuppliers(Model model){
       List<Supplier> listSuppliers = repo.findAll();
       
       model.addAttribute("listSuppliers",listSuppliers);


       return "suppliers";
   }

    @GetMapping("/suppliers/show/{id_Sap}")
    public  String showEditComponentForm(@PathVariable("id_Sap") String id_Sap, Model model){
       // System.out.println("id_Sap:  "+id_Sap.toString());

        List<ComponentPSCPS> listComponentsPSCPSWhith_Id_Sap = componentPSCPSRepo.findAll();
        List<ComponentPSAPT> listComponentsPSAPTWhith_Id_Sap = componentPSAPTRepo.findAll();
               // System.out.println("Wszystkie ListComponents:  "+listComponentsWhith_Id_Sap.toString());
        List<ComponentPSCPS> listaPSCPS = nowalistaPSCPS(listComponentsPSCPSWhith_Id_Sap, id_Sap );//podaje listę Componnetów które mają id_Sap równe id_Sap jak Supplier
        List<ComponentPSAPT> listaPSAPT = nowalistaPSAPT(listComponentsPSAPTWhith_Id_Sap, id_Sap );
        
        List<Supplier>       listSppliers   =     repo.findAll(); // lista wszystkich Suppliers
        List<Supplier>   listSppliers2 =   nowalista2(listSppliers, id_Sap );
        String supplierName2 =  listSppliers2.stream().findFirst().get().getName();// podaje pierwszy element
        Long supplierTotalScore =  listSppliers2.stream().findFirst().get().getTotalScore();
        String supplierClass =  listSppliers2.stream().findFirst().get().getClassification();
       System.out.println("supplierTotalScore:"+supplierTotalScore.toString()); 
        // listSppliers2.stream().findFirst().get().getName().toString();
        System.out.println("SupplierName2:"+supplierName2);
                   //   String supplierName =  supplier2.get().getName();
                           //supplier2.stream().findFirst().;
        model.addAttribute("supplierName2", supplierName2);
        model.addAttribute("supplierTotalScore", supplierTotalScore);
        model.addAttribute("supplierClass", supplierClass);
        if(!listaPSAPT.isEmpty() && listaPSAPT !=null) {
        	 	model.addAttribute("listaPSAPT", listaPSAPT);
        }else System.out.println("listaPSAPT  jest pusta");
        if(!listaPSCPS.isEmpty() && listaPSCPS !=null){
        	model.addAttribute("listaPSCPS", listaPSCPS);
        }else System.out.println("listaPSCPS  jest pusta");

        return "components_by_Id_Sap.html";
    }

    private List<Supplier> nowalista2(List<Supplier> listSppliers, String id_Sap) {
        List<Supplier> listSppliers2 = new ArrayList<>();
        for (Supplier supplier : listSppliers
        ) {
            String id_sap = supplier.getId_Sap();
            //  System.out.println("To jest id_sap:  "+ id_sap.toString());
            //  System.out.println("To jest id_Sap:  "+id_Sap.toString());
            if (id_sap.toString().equals(id_Sap.toString())) {
                int i = 1;
                i++;
                //   System.out.println("czemu to jest wykonane:   "+i);
                //   System.out.println("To jest id_sap: "+id_sap.toString());
                listSppliers2.add(supplier);
            }
        }
        return listSppliers2;
    }

   private List<ComponentPSCPS> nowalistaPSCPS(List<ComponentPSCPS> lista, String id_Sap) {
        List<ComponentPSCPS> listaPSCPS =new ArrayList<>();
       //System.out.println("Nowa ListComponents_przed :"+lista3);
        for (ComponentPSCPS component:lista
        ) {
           String id_sap = component.getId_Sap();
          //  System.out.println("To jest id_sap:  "+ id_sap.toString());
          //  System.out.println("To jest id_Sap:  "+id_Sap.toString());
            if (id_sap.toString().equals(id_Sap.toString())){
                int i=1;i++;
             //   System.out.println("czemu to jest wykonane:   "+i);
             //   System.out.println("To jest id_sap: "+id_sap.toString());
              listaPSCPS.add(component);
           }
//
           // System.out.println("Nowa ListComponents:  "+lista3.toString());
        }
       // System.out.println("Nowa ListComponents_2:  "+lista3.toString());
        return listaPSCPS;
    }
   
   
   
   private List<ComponentPSAPT> nowalistaPSAPT(List<ComponentPSAPT> lista, String id_Sap) {
       List<ComponentPSAPT> listaPSAPT =new ArrayList<>();
      //System.out.println("Nowa ListComponents_przed :"+lista3);
       for (ComponentPSAPT component:lista
       ) {
          String id_sap = component.getId_Sap();
         //  System.out.println("To jest id_sap:  "+ id_sap.toString());
         //  System.out.println("To jest id_Sap:  "+id_Sap.toString());
           if (id_sap.toString().equals(id_Sap.toString())){
               int i=1;i++;
            //   System.out.println("czemu to jest wykonane:   "+i);
            //   System.out.println("To jest id_sap: "+id_sap.toString());
             listaPSAPT.add(component);
          }
//
          // System.out.println("Nowa ListComponents:  "+lista3.toString());
       }
      // System.out.println("Nowa ListComponents_2:  "+lista3.toString());
       return listaPSAPT;
   }

   
   
   
    @GetMapping("/suppliers/new")
    public String showCategoryNewForm(Model model){

        model.addAttribute("category",new Supplier());
        return "suppliers_form";
    }

    // tworzenie dziaąlnia dla save
    @PostMapping("/suppliers/save")
    public String saveCategory(Supplier category){
       repo.save(category);
       return "redirect:/suppliers";

    }
    @RequestMapping(value="classification", method = RequestMethod.GET)
    public String classification(Model model) {
        //model.addAttribute("listSubClass",listSupClass);
       // model.addAttribute("supplierName2", supplierName2);

        return "supplier/chart";
    }
    @RequestMapping(value="getClassification", method = RequestMethod.GET)
    public String getClassification(Model model) {
        //model.addAttribute("listSubClass",listSupClass);
        // model.addAttribute("supplierName2", supplierName2);

        return "supplier/getClassification";
    }

}
