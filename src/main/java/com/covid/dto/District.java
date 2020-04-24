package com.covid.dto;

public class District
{
    private String recovered;

    private String deceased;

    private Delta delta;

    private String active;

    private String confirmed;

    public String getRecovered ()
    {
        return recovered;
    }

    public void setRecovered (String recovered)
    {
        this.recovered = recovered;
    }

    public String getDeceased ()
    {
        return deceased;
    }

    public void setDeceased (String deceased)
    {
        this.deceased = deceased;
    }

    public Delta getDelta ()
    {
        return delta;
    }

    public void setDelta (Delta delta)
    {
        this.delta = delta;
    }

    public String getActive ()
    {
        return active;
    }

    public void setActive (String active)
    {
        this.active = active;
    }

    public String getConfirmed ()
    {
        return confirmed;
    }

    public void setConfirmed (String confirmed)
    {
        this.confirmed = confirmed;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [recovered = "+recovered+", deceased = "+deceased+", delta = "+delta+", active = "+active+", confirmed = "+confirmed+"]";
    }
}
