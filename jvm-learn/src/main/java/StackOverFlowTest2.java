import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

/**
 * 对象之间产生递归，通过注解解决栈内存溢出
 * @author lmf
 * @version 1.0
 * @date 2022/10/31 14:46
 */
public class StackOverFlowTest2 {

    public static void main(String[] args) throws JsonProcessingException {
        Dept dept = new Dept();
        dept.setName("AAA");
        Emp emp = new Emp();
        emp.setName("A");
        emp.setDept(dept);
        Emp emp2 = new Emp();
        emp2.setName("b");
        emp2.setDept(dept);
        dept.setEmps(Arrays.asList(emp,emp2));
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("objectMapper.writeValueAsString(dept) = " + objectMapper.writeValueAsString(dept));
    }



}
class Emp{
    private String name;

    @JsonIgnore
    private Dept dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}

class Dept{
    private String name;
    private List<Emp> emps;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }
}