package udea.com.co.model;

public class Sale {
    private String saleId;
    private String saleDetail;

    public Sale() {
    }

    public Sale(String saleId, String saleDetail) {
        this.saleId = saleId;
        this.saleDetail = saleDetail;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public String getSaleDetail() {
        return saleDetail;
    }

    public void setSaleDetail(String saleDetail) {
        this.saleDetail = saleDetail;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleId='" + saleId + '\'' +
                ", saleDetail='" + saleDetail + '\'' +
                '}';
    }
}
