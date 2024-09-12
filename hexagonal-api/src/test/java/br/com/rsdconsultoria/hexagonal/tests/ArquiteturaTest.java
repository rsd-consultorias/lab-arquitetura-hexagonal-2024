package br.com.rsdconsultoria.hexagonal.tests;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

import org.junit.jupiter.api.Test;

public class ArquiteturaTest {

        @Test
        public void domainServicesShouldOnlyBeAccessedByApplicationServices() {
                JavaClasses importedClasses = new ClassFileImporter()
                                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                                .importPackages("br.com.rsdconsultoria.hexagonal");

                ArchRule domainServices = ArchRuleDefinition.classes()
                                .that().resideInAPackage("br.com.rsdconsultoria.hexagonal.domain.service..")
                                .should().onlyBeAccessed()
                                .byAnyPackage("br.com.rsdconsultoria.hexagonal.application..");

                domainServices.check(importedClasses);
        }

        @Test
        public void controllersShouldNotAccessCertainPackages() {
                JavaClasses importedClasses = new ClassFileImporter()
                                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                                .importPackages("br.com.rsdconsultoria.hexagonal");

                ArchRule controllers = ArchRuleDefinition.classes()
                                .that().resideInAPackage("br.com.rsdconsultoria.hexagonal.web.controller..")
                                .should().onlyAccessClassesThat()
                                .resideOutsideOfPackages(
                                                "br.com.rsdconsultoria.hexagonal.domain.service..",
                                                "br.com.rsdconsultoria.hexagonal.domain.repository..",
                                                "br.com.rsdconsultoria.hexagonal.application.port..",
                                                "br.com.rsdconsultoria.hexagonal.infrastructure.adapter..");

                controllers.check(importedClasses);
        }
}
