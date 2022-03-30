package pl.olointeria.spring_08_mysql_company.prima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.olointeria.spring_08_mysql_company.component.Component;
import pl.olointeria.spring_08_mysql_company.component.ComponentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class SupplierController {
    @Autowired

    private SupplierRepository repo;
    @Autowired
    private ComponentRepository  componentRepo;

    public SupplierController(ComponentRepository componentRepo) {
        this.componentRepo = componentRepo;
    }

    @GetMapping("/suppliers")
    public String listSuppliers(Model model){
       List<Supplier> listSuppliers = repo.findAll();
       
       model.addAttribute("listSuppliers",listSuppliers);


       return "suppliers";
   }

    @GetMapping("/suppliers/show/{id_Sap}")
    public  String showEditComponentForm(@PathVariable("id_Sap") String id_Sap, Model model){
       // System.out.println("id_Sap:  "+id_Sap.toString());

        List<Component> listComponentsWhith_Id_Sap = componentRepo.findAll();
               // System.out.println("Wszystkie ListComponents:  "+listComponentsWhith_Id_Sap.toString());
        List<Component> lista2 = nowalista(listComponentsWhith_Id_Sap, id_Sap );//podaje listę Componnetów które mają id_Sap równe id_Sap jak Supplier

        List<Supplier>       listSppliers   =     repo.findAll(); // lista wszystkich Suppliers
        List<Supplier>   listSppliers2 =   nowalista2(listSppliers, id_Sap );
        String supplierName2 =  listSppliers2.stream().findFirst().get().getName();// podaje pierwszy element
        // listSppliers2.stream().findFirst().get().getName().toString();
       // System.out.println("SupplierName2:"+supplierName2);
                   //   String supplierName =  supplier2.get().getName();
                           //supplier2.stream().findFirst().;
        model.addAttribute("supplierName2", supplierName2);
        model.addAttribute("lista2", lista2);



        return "components_by_Id_Sap";
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

    private List<Component> nowalista(List<Component> lista, String id_Sap) {
        List<Component> lista2 =new ArrayList<>();
       //System.out.println("Nowa ListComponents_przed :"+lista3);
        for (Component component:lista
        ) {
            String id_sap = component.getId_Sap();
          //  System.out.println("To jest id_sap:  "+ id_sap.toString());
          //  System.out.println("To jest id_Sap:  "+id_Sap.toString());
            if (id_sap.toString().equals(id_Sap.toString())){
                int i=1;i++;
             //   System.out.println("czemu to jest wykonane:   "+i);
             //   System.out.println("To jest id_sap: "+id_sap.toString());
              lista2.add(component);
            }

           // System.out.println("Nowa ListComponents:  "+lista3.toString());
        }
       // System.out.println("Nowa ListComponents_2:  "+lista3.toString());
        return lista2;
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

}
