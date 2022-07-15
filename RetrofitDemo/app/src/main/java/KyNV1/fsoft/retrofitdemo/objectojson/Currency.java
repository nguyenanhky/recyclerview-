package KyNV1.fsoft.retrofitdemo.objectojson;

import com.google.gson.annotations.SerializedName;



public class Currency  {

    @SerializedName("success")
    private boolean success;

    @SerializedName("terms")
    private String terms;

    @SerializedName("privacy")
    private String privacy;

    @SerializedName("timestamp")
    private float timestamp;

    @SerializedName("source")
    private String source;

    @SerializedName("quotes")
    private Quotes quotes;

    // getter and setter


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public float getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(float timestamp) {
        this.timestamp = timestamp;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Quotes getQuotes() {
        return quotes;
    }

    public void setQuotes(Quotes quotes) {
        this.quotes = quotes;
    }


}
