import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.internal.NotNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Objects;

public class FilterOption implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("value")
    private String value = null;
    @JsonProperty("count")
    private Integer count = null;

    public FilterOption() {
    }

    public FilterOption value(String value) {
        this.value = value;
        return this;
    }

    @NotNull
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public FilterOption count(Integer count) {
        this.count = count;
        return this;
    }

    @NotNull
    @Min(0L)
    @Max(500L)
    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            FilterOption filterOption = (FilterOption)o;
            return Objects.equals(this.value, filterOption.value) && Objects.equals(this.count, filterOption.count);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.value, this.count});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FilterOption {\n");
        sb.append("    value: ").append(this.toIndentedString(this.value)).append("\n");
        sb.append("    count: ").append(this.toIndentedString(this.count)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}
