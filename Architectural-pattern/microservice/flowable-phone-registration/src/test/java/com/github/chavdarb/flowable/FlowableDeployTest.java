package com.github.chavdarb.flowable;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.ProcessDefinition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlowableDeployTest {

    @Autowired
    RepositoryService repositoryService;

    @Test
    void testProcessDeployed() {
        assertThat(repositoryService).isNotNull();
        List<ProcessDefinition> processDefinitionList = repositoryService.createProcessDefinitionQuery().list();
        for (ProcessDefinition processDefinition: processDefinitionList) {
            System.out.println(processDefinition.getId());
            System.out.println(processDefinition.getKey());
            System.out.println(processDefinition.getName());
        }
        assertThat(repositoryService.createProcessDefinitionQuery().processDefinitionKey("phone-registration").list().size()).isEqualTo(1);
    }

}
