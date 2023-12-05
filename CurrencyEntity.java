package currency.example.currency.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "currency_table")
public class CurrencyEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "success")
    private Boolean success;
    @Column(name = "terms")
    private String terms;
    @Column(name = "privacy")
    private String privacy;
    @Column(name = "timestamp")
    private Date timestamp;
    @Column(name = "source")
    private String source;

    @Column(name = "quotes")
    private String quotes;

    public CurrencyEntity() {
    }

    public CurrencyEntity(Integer id, Boolean success, String terms, String privacy, Date timestamp, String source, String quotes) {
        this.id = id;
        this.success = success;
        this.terms = terms;
        this.privacy = privacy;
        this.timestamp = timestamp;
        this.source = source;
        this.quotes = quotes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getQuotes() {
        return quotes;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }
}
