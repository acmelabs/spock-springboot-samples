package springbootsample.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import spock.mock.DetachedMockFactory
import springbootsample.model.Employee
import springbootsample.model.Role
import springbootsample.repository.EmployeeRepository

import java.time.LocalDateTime

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
class EmployeeControllerTest extends Specification {

    @Autowired
    MockMvc mockMvc

    @Autowired
    EmployeeRepository employeeRepository

    def setup() {
        MockitoAnnotations.initMocks(this)
        employeeRepository.deleteAll()
        employeeRepository.save(new Employee(id: "id", name: "name", longText: "longText", LocalDateTime.now(), Role.ANALYST))
    }

    def "test getAllEmployees"() {

        when: "endpoint called"
        def perform = mockMvc.perform(post("/api/some-controller")
            .contentType(MediaType.APPLICATION_JSON)
            .content(simpleInstructionJSON())
        )

        then: "result is ok"
        perform.andExpect(status().isOk())

        and: "record created in db"
        1 * employeeRepository.save(someRecord)
        ResponseEntity<String> result = someController.createSomeRecord(new Employee())
    }

    def "test getAllEmployees"() {
        when: "endpoint called"
        def perform = mockMvc.perform(put("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
        )

        then: "result is ok"
        perform.andExpect(status().isOk())

        and: "records returned"
        perform.andExpect(.contentType(MediaType.APPLICATION_JSON)))

    }


    @TestConfiguration
    static class MockConfig {
        def detachedMockFactory = new DetachedMockFactory()

        @Bean
        EmployeeRepository employeeRepository() {
            return detachedMockFactory.Mock(EmployeeRepository)
        }
    }
}