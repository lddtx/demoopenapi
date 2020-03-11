package org.wj.prajumsook;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.wj.prajumsook.api.MemberController;
import org.wj.prajumsook.entity.Member;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureRestDocs
public class MemberControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberController memberController;

    @Test
    public void testGetAll() throws Exception {
        List<Member> members = Arrays.asList(
                new Member(0, "first name", "last name"),
                new Member(1, "first name", "last name"),
                new Member(2, "first name", "last name")
        );

        ResponseEntity responseEntity = new ResponseEntity(members ,HttpStatus.OK);
        when(memberController.all()).thenReturn(responseEntity);


        mockMvc.perform(get("/member"))
                .andExpect(status().isOk())
                .andDo(document(
                        "get-all-member",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())
                ));
    }
}
