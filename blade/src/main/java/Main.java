import com.blade.Blade;
import com.blade.mvc.RouteContext;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.PostRoute;

public class Main {
    public static void main(String[] args) {
        //Blade.of().get("/", ctx -> ctx.text("Hello world!")).start();

        /*Blade.of().get("/user", ctx -> {
            Integer age = ctx.fromInt("age");
            System.out.println("age is:" + age);
        }).start();*/

    }
}
