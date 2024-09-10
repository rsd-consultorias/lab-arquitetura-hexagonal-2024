package br.com.rsdconsultoria.hexagonal.tests;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArquiteturaTest {

    // @Test
    // void servicosDevemEstarNoPacoteService() {
    // JavaClasses importedClasses = new
    // ClassFileImporter().importPackages("br.com.rsdconsultoria.hexagonal");

    // ArchRule regra = classes()
    // .that().resideInAPackage("..application.service..")
    // .should().onlyBeAccessed().byAnyPackage("..application.service..",
    // "..application.port..");

    // regra.check(importedClasses);
    // }

    // @Test
    // void arquiteturaEmCamadas() {
    //     JavaClasses importedClasses = new ClassFileImporter()
    //             .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
    //             .importPackages("br.com.rsdconsultoria.hexagonal");

    //     ArchRule regra = Architectures.onionArchitecture()
    //             .applicationServices("br.com.rsdconsultoria.hexagonal.application.service..")
    //             .domainServices("br.com.rsdconsultoria.hexagonal.domain.service..")
    //             .domainModels("br.com.rsdconsultoria.hexagonal.domain.model..");

    //     regra.check(importedClasses);
    // }

    @Test
    void adaptadoresNaoDevemAcessarDiretamenteRepositorios() {
        JavaClasses importedClasses = new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .importPackages("br.com.rsdconsultoria.hexagonal");

        ArchRule regra = classes()
                .that().resideInAPackage("br.com.rsdconsultoria.hexagonal.domain.service..")
                .should().onlyBeAccessed().byAnyPackage("br.com.rsdconsultoria.hexagonal.application..");

        regra.check(importedClasses);
    }
}
