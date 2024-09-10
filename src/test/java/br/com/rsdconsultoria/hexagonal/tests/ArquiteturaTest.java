package br.com.rsdconsultoria.hexagonal.tests;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArquiteturaTest {

    @Test
    void garantirArquitetura() {
        JavaClasses importedClasses = new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .importPackages("br.com.rsdconsultoria.hexagonal", "java.lang..", "java.util..", "java.math..");

        // Domain Services só podem ser acessadas pela Application Service
        ArchRule domainServices = classes()
                .that().resideInAPackage("br.com.rsdconsultoria.hexagonal.domain.service..")
                .should().onlyBeAccessed().byAnyPackage("br.com.rsdconsultoria.hexagonal.application..");

        domainServices.check(importedClasses);

    }
}
