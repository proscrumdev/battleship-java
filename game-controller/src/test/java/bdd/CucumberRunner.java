package bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/bdd"},
        plugin = {"pretty", "html:build/bdd/cucumber-html-report", "junit:build/bdd/cucumber-junit-report/allcukes.xml"},
        tags = "@Runme")
public class CucumberRunner {
}
