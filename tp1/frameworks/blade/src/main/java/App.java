import com.blade.Blade;

public class App {
    public static void main(String[] args) {
        /*Blade blade = Blade.me();

        blade.start(App.class, args);*/

        Blade.of().get("/", ctx -> ctx.text("Hello world!")).start();

        /*Blade.of().get("/user", ctx -> {
            Integer age = ctx.fromInt("age");
            System.out.println("age is:" + age);
        }).start();*/

        /*Blade.of()
                .get("/get", ctx -> ctx.text("GET called"))
                .post("/basic-routes-example", ctx -> ctx.text("POST called"))
                .put("/basic-routes-example", ctx -> ctx.text("PUT called"))
                .delete("/basic-routes-example", ctx -> ctx.text("DELETE called"))
                .start(App.class, args);*/

        //Blade.of().start(RouteExampleController.class);

    }
}
