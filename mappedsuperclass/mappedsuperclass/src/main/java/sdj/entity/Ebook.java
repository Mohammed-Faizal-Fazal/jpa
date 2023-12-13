package sdj.entity;

import javax.persistence.Entity;

@Entity
public class Ebook extends Book{
	
    private String format;

    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return super.toString() + ", Ebook{" + "format=" + format + '}';
    }

}
