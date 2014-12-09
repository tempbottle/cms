package com.cms.test.controller;

import com.cms.application.controllers.ContentController;
import com.cms.test.CMSTestContext;
import com.cms.test.WebAppContext;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsAnything;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRule;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.Parameter;
import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppContext.class, CMSTestContext.class})
@WebAppConfiguration
public class GreetingControllerTest {

    private MockMvc mockMvc;

    // A mock object
    @Autowired
    private ContentController contentServiceMock;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        Mockito.reset(contentServiceMock);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        //this.greetingServiceMock = Mockito.mock(GreetingController.class);
    }

    @Test
    public void greeting_badTest() throws Exception {

        MockitoAnnotations.initMocks(this);
        //when(contentServiceMock.post("testTitle", "testEntry")).thenReturn(); // .thenReturn(new Greeting(1, "name"));

//        mockMvc.perform(get("/greeting?name=name"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType("application/json;charset=UTF-8"))
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.content").value("Hello, name!"));
//        verify(greetingServiceMock, times(1)).greeting("name");
//        //verifyNoMoreInteractions(greetingServiceMock);
    }


    // in the test
//    IDep1 dependency1Mock;
//    IDep2 dependency2Mock;
//
//    when(depedency1Mock.functionOnDep1("string")).thenReturn(5);
//    when(dependency2Mock.functionOnDep2("diffString")).thenReturn(5);
//
//    someClass sc = new someClass(dependency1Mock, dependency2Mock);
//    verify(sc.SomeFunction() == 10);
//
//    class someClass {
//        IDep1 dep1;
//        IDep2 dep2;
//        someClass(IDep1 dependency, IDep2 depedency2) {
//            this.dep1 = depedency;
//            this.dep2 = dependency2;
//        }
//
//
//        public value SomeFunction() {
//            return dep1.functionOnDep1("string") + dep2.functionOnDep2("diffString");
//        }
//    }


}