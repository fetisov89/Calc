package ru.skypro.calculator.Controller;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.calculator.Servis.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }


    @GetMapping
    public String greeting() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(name = "num1",required = false) Integer a,
                       @RequestParam(name = "num2",required = false) Integer b) {
        if (a == null || b == null) {
            System.out.println("Одино из чисел не указано");
        }
        return a + " + " + b + " = " + service.plus(a, b);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(name = "num1",required = false) Integer a,
                        @RequestParam(name = "num2",required = false) Integer b) {
        if (a == null || b == null) {
            System.out.println("Одино из чисел не указано");
        }
        return a + " - " + b + " = " + service.minus(a, b);
    }

    @GetMapping("/multiplication")
    public String multiplication(@RequestParam(name = "num1",required = false) Integer a,
                                 @RequestParam(name = "num2",required = false) Integer b) {
        if (a == null || b == null) {
            System.out.println("Одино из чисел не указано");
        }
        return a + " * " + b + " = " + service.multiplication(a, b);
    }

    @GetMapping("/dividing")
    public String dividing(@RequestParam(defaultValue = "1") Integer a,
                           @RequestParam(defaultValue = "1")  Integer b)
    {
        if (a == null || b == null) {
            System.out.println("Одино из чисел не указано");
        }
        if (b == 0) {
            System.out.println("Нельзя делить на 0");
        }
        return a + " / " + b + " = " + service.dividing(a, b);
    }
}