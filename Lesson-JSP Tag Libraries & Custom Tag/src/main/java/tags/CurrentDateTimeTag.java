package tags;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CurrentDateTimeTag extends SimpleTagSupport {
    private String color = "black";
    private String size = "14px";

    public void setColor(String color) {
        if (color != null && !color.isEmpty()) {
            this.color = color;
        }
    }

    public void setSize(String size) {
        if (size != null && !size.isEmpty()) {
            this.size = size;
        }
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        String formattedDate = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz")
                .format(new Date());

        out.write(String.format(
                "<span style='color: %s; font-size: %s;'>%s</span>",
                color, size, formattedDate
        ));
    }
}