package caccia.david.org.catalog_convert.example_extension;

import caccia.david.org.catalog_convert.data.BaseProduct;

import java.util.Date;

public class ExtendedProduct extends BaseProduct
{
    private String location;

    private Date start;

    private Date end;

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public Date getStart()
    {
        return start;
    }

    public void setStart(Date start)
    {
        this.start = start;
    }

    public Date getEnd()
    {
        return end;
    }

    public void setEnd(Date end)
    {
        this.end = end;
    }
}
