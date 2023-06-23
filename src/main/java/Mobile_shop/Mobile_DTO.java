package Mobile_shop;

public class Mobile_DTO {

    private int modelNo;
    private String modelName;
    private String company;
    private String ram;
    private String cameraPixel;
    private double price;

    public int getModelNo() {
        return modelNo;
    }

    public void setModelNo(int modelNo) {
        this.modelNo = modelNo;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getCameraPixel() {
        return cameraPixel;
    }

    public void setCameraPixel(String cameraPixel) {
        this.cameraPixel = cameraPixel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  modelNo + "\t" +
                modelName + "\t" +
                company + "\t" +
                ram + "\t" +
                cameraPixel + "\t" +
                price;
    }
}
