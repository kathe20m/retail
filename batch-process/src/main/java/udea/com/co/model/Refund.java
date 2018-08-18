package udea.com.co.model;

public class Refund {
    private String refundId;
    private String refundDetail;

    public Refund() {
    }

    public Refund(String refundId, String refundDetail) {
        this.refundId = refundId;
        this.refundDetail = refundDetail;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getRefundDetail() {
        return refundDetail;
    }

    public void setRefundDetail(String refundDetail) {
        this.refundDetail = refundDetail;
    }

    @Override
    public String toString() {
        return "Refund{" +
                "refundId='" + refundId + '\'' +
                ", refundDetail='" + refundDetail + '\'' +
                '}';
    }
}
