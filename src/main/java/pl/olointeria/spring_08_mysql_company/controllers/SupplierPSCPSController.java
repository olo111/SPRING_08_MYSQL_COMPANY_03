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
import pl.olointeria.spring_08_mysql_company.prima.*;

import javax.xml.XMLConstants;
//@RestController
@Controller
public class SupplierPSCPSController {
    @Autowired

    private SupplierPSCPSRepository repo;
    @Autowired
    private ComponentPSCPSRepository  componentPSCPSRepo;

    @Autowired
    private ComponentPSAPTRepository  componentPSAPTRepo;

    @Autowired
    private ComponentRepository  componentRepo;

    // public SupplierController(ComponentRepository componentRepo) {
    //    this.componentRepo = componentRepo;
    // }
    //PODWOJONY MAPPING "/home"
//    @GetMapping("/home")
//    String home() {
//        //ewentualna logika metody
//        return "index.html"; //nazwa pliku w katalogu /templates
//    }
//    @PostMapping ("/")
//    String home2() {
//        //ewentualna logika metody
//        return "index.html"; //nazwa pliku w katalogu /templates
//    }

    @GetMapping("/suppliersPSCPS")
    public String listSuppliers(Model model){
        List<SupplierPSCPS> listSuppliers = repo.findAll();

        model.addAttribute("listSuppliers",listSuppliers);


        return "supplier/suppliersPSCPS";
    }
    @GetMapping("/suppliersPSCPS/show2/{classification}")
    public  String showListSupWithClassification(@PathVariable("classification") String classification, Model model) {
        List<SupplierPSCPS> listSupPSCPSWhith_Class = repo.findAll();
        System.out.println("wydruk dla wartości classification"+classification);
        System.out.println("wydruk dla wartości classification to String "+classification.toString());
        System.out.println("sprawdzenie jak traktuje classification. toUpper" + classification.toUpperCase() );
        List<SupplierPSCPS> listaPSCPSwithClass = nowalistaPSCPSwithClass(listSupPSCPSWhith_Class, classification.toString() );
        model.addAttribute("listaPSCPSwithClass", listaPSCPSwithClass);
        model.addAttribute("classification", classification);
        return "supplier/suppliersPSCPSWithClass";
    }

    private List<SupplierPSCPS> nowalistaPSCPSwithClass(List<SupplierPSCPS> listComponentsPSCPSWhith_class, String classification) {
        List<SupplierPSCPS> listSppliers2 = new ArrayList<>();
        for (SupplierPSCPS supplierPSCPS : listComponentsPSCPSWhith_class
        ) {
            String classifi_2  =supplierPSCPS.getClassification();

            if (classifi_2.equals(classification)) {
                int i = 1;
                i++;
                //   System.out.println("czemu to jest wykonane:   "+i);
                //   System.out.println("To jest id_sap: "+id_sap.toString());
                listSppliers2.add(supplierPSCPS);
            }
        }
        return listSppliers2;
    }

    @GetMapping("/suppliersPSCPS/show/{id_Sap}")
    public  String showEditComponentForm(@PathVariable("id_Sap") String id_Sap, Model model){
        // System.out.println("id_Sap:  "+id_Sap.toString());

        List<ComponentPSCPS> listComponentsPSCPSWhith_Id_Sap = componentPSCPSRepo.findAll();
      //  List<ComponentPSAPT> listComponentsPSAPTWhith_Id_Sap = componentPSAPTRepo.findAll();
        // System.out.println("Wszystkie ListComponents:  "+listComponentsWhith_Id_Sap.toString());
        List<ComponentPSCPS> listaPSCPS = nowalistaPSCPS(listComponentsPSCPSWhith_Id_Sap, id_Sap );//podaje listę Componnetów które mają id_Sap równe id_Sap jak Supplier
     //   List<ComponentPSAPT> listaPSAPT = nowalistaPSAPT(listComponentsPSAPTWhith_Id_Sap, id_Sap );

        List<SupplierPSCPS>       listSppliers   =     repo.findAll(); // lista wszystkich Suppliers
        List<SupplierPSCPS>   listSppliers2 =   nowalista2(listSppliers, id_Sap );
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
     //   if(!listaPSAPT.isEmpty() && listaPSAPT !=null) {
       //     model.addAttribute("listaPSAPT", listaPSAPT);
      //  }else System.out.println("listaPSAPT  jest pusta");
        if(!listaPSCPS.isEmpty() && listaPSCPS !=null){
            model.addAttribute("listPSCPSComponents", listaPSCPS);
                    }else System.out.println("listaPSCPS  jest pusta");

        return "component/components_PSCPS_SapSUPPLIER.html";
    }

    private List<SupplierPSCPS> nowalista2(List<SupplierPSCPS> listSppliers, String id_Sap) {
        List<SupplierPSCPS> listSppliers2 = new ArrayList<>();
        for (SupplierPSCPS supplier : listSppliers
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




    @GetMapping("/suppliersPSCPS/new")
    public String showCategoryNewForm(Model model){

        model.addAttribute("category",new SupplierPSCPS());
        return "suppliers_pscps_form";
    }

    // tworzenie dziaąlnia dla save
    @PostMapping("/suppliersPSCPS/save")
    public String saveCategory(SupplierPSCPS category){
        repo.save(category);
        return "redirect:supplier/suppliersPSCPS";

    }
    @RequestMapping(value="classificationPSCPS", method = RequestMethod.GET)
    public String classificationPSCPS(Model model) {
        //model.addAttribute("listSubClass",listSupClass);
        // model.addAttribute("supplierName2", supplierName2);

        return "supplier/chartPSCPS";
    }
    @RequestMapping(value="getClassificationPSCPS", method = RequestMethod.GET)
    public String getClassificationPSCPS(Model model) {
        //model.addAttribute("listSubClass",listSupClass);
        // model.addAttribute("supplierName2", supplierName2);

        return "supplier/getClassificationPSCPS";
    }

    @RequestMapping(value={"/classification/classific","/suppliersPSCPS/classification/classific"})
    public String classification(Model model) {
               return "classification/classific";
    }
    @RequestMapping(value={"/classification/ppm","/suppliersPSCPS/classification/ppm"})
    public String ppm(Model model) {
        return "classification/ppm";}

    @RequestMapping(value={"/classification/certificate","/suppliersPSCPS/classification/certificate"})
        public String certificate(Model model) {
            return "classification/certificate";
        }
     @RequestMapping(value={"/classification/approval","/suppliersPSCPS/classification/approval"})
    public String approval(Model model) {
        return "classification/approval";
    }
    @RequestMapping(value={"/classification/audit_result","/suppliersPSCPS/classification/audit_result"})
    public String audit_result(Model model) {
        return "classification/audit_result";
    }
    @RequestMapping(value={"/classification/pscr","/suppliersPSCPS/classification/pscr"})
    public String pscr(Model model) {
        return "classification/pscr";
    }
    @RequestMapping(value={"/classification/location","/suppliersPSCPS/classification/location"})
    public String location(Model model) {
        return "classification/location";
    }
    @RequestMapping(value={"/classification/delays","/suppliersPSCPS/classification/delays"})
    public String delays(Model model) {
        return "classification/delays";
    }

    @GetMapping(value={"/classification/interference","/suppliersPSCPS/classification/interference"})
    public String interference(Model model) {
        return "classification/interference";
    }
    @RequestMapping(value={"/classification/collaboration","/suppliersPSCPS/classification/collaboration"})
    public String collaboration(Model model) {
        return "classification/collaboration";
    }
    @RequestMapping(value={"/classification/average_score","/suppliersPSCPS/classification/average_score"})
    public String average_score(Model model) {
        return "classification/average_score";
    }
}

