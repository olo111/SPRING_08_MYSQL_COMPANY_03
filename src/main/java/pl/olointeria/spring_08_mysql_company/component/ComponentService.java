//package pl.olointeria.spring_08_mysql_company.component;
//
//import pl.olointeria.spring_08_mysql_company.prima.Supplier;
//
//import javax.persistence.*;
//
//@Entity
//public class Component {
//
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    private Long id;
//    private String sapName;
//    private String sapNumber;
//    private Long id_Sap;
//    private String customer;
//    private Double ppm;
//    private Double certificate;
//    private Double approval;
//    private Double auditResult;
//    private Double pscr;
//    private Double location;
//    private Double deliveryDeley;
//    private Double interference;
//    private Double collaboration;
//    private Double averageScore;
//
//    @ManyToOne
//    @JoinColumn(name = "supplier_id")
//    private Supplier supplier;
//
//
//    public Component(){};
//
//    public Component(Long id, String sapName, String sapNumber, Long id_Sap, String customer, Double ppm, Double certificate, Double approval, Double auditResult, Double pscr, Double location, Double deliveryDeley, Double interference, Double collaboration, Double averageScore, Supplier supplier) {
//        this.id = id;
//        this.sapName = sapName;
//        this.sapNumber = sapNumber;
//        this.id_Sap = id_Sap;
//        this.customer = customer;
//        this.ppm = ppm;
//        this.certificate = certificate;
//        this.approval = approval;
//        this.auditResult = auditResult;
//        this.pscr = pscr;
//        this.location = location;
//        this.deliveryDeley = deliveryDeley;
//        this.interference = interference;
//        this.collaboration = collaboration;
//        this.averageScore = averageScore;
//        this.supplier = supplier;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getSapName() {
//        return sapName;
//    }
//
//    public void setSapName(String sapName) {
//        this.sapName = sapName;
//    }
//
//    public String getSapNumber() {
//        return sapNumber;
//    }
//
//    public void setSapNumber(String sapNumber) {
//        this.sapNumber = sapNumber;
//    }
//
//    public Long getId_Sap() {
//        return id_Sap;
//    }
//
//    public void setId_Sap(Long id_Sap) {
//        this.id_Sap = id_Sap;
//    }
//
//    public String getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(String customer) {
//        this.customer = customer;
//    }
//
//    public Double getPpm() {
//        return ppm;
//    }
//
//    public void setPpm(Double ppm) {
//        this.ppm = ppm;
//    }
//
//    public Double getCertificate() {
//        return certificate;
//    }
//
//    public void setCertificate(Double certificate) {
//        this.certificate = certificate;
//    }
//
//    public Double getApproval() {
//        return approval;
//    }
//
//    public void setApproval(Double approval) {
//        this.approval = approval;
//    }
//
//    public Double getAuditResult() {
//        return auditResult;
//    }
//
//    public void setAuditResult(Double auditResult) {
//        this.auditResult = auditResult;
//    }
//
//    public Double getPscr() {
//        return pscr;
//    }
//
//    public void setPscr(Double pscr) {
//        this.pscr = pscr;
//    }
//
//    public Double getLocation() {
//        return location;
//    }
//
//    public void setLocation(Double location) {
//        this.location = location;
//    }
//
//    public Double getDeliveryDeley() {
//        return deliveryDeley;
//    }
//
//    public void setDeliveryDeley(Double deliveryDeley) {
//        this.deliveryDeley = deliveryDeley;
//    }
//
//    public Double getInterference() {
//        return interference;
//    }
//
//    public void setInterference(Double interference) {
//        this.interference = interference;
//    }
//
//    public Double getCollaboration() {
//        return collaboration;
//    }
//
//    public void setCollaboration(Double collaboration) {
//        this.collaboration = collaboration;
//    }
//
//    public Double getAverageScore() {
//        return averageScore;
//    }
//
//    public void setAverageScore(Double averageScore) {
//        this.averageScore = averageScore;
//    }
//
//    @Override
//    public String toString() {
//        return "Component{" +
//                "id=" + id +
//                ", sapName='" + sapName + '\'' +
//                ", sapNumber='" + sapNumber + '\'' +
//                ", id_Sap=" + id_Sap +
//                ", customer='" + customer + '\'' +
//                ", ppm=" + ppm +
//                ", certificate=" + certificate +
//                ", approval=" + approval +
//                ", auditResult=" + auditResult +
//                ", pscr=" + pscr +
//                ", location=" + location +
//                ", deliveryDeley=" + deliveryDeley +
//                ", interference=" + interference +
//                ", collaboration=" + collaboration +
//                ", averageScore=" + averageScore +
//
//                '}';
//    }
//}
