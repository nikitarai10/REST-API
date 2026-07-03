package Spring.REST.API.Service;

import java.util.List;

import Spring.REST.API.DTO.AddStudentRequestDTO;
import Spring.REST.API.DTO.PatchStudentRequestDTO;
import Spring.REST.API.DTO.StudentDTO;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(Long id);

    StudentDTO createNewStudent(AddStudentRequestDTO addStudentRequestDTO);

    void deleteStudentById(Long id);

    StudentDTO updateStudent(Long id,AddStudentRequestDTO addStudentRequestDTO);

    StudentDTO updatePartialStudent(Long id, PatchStudentRequestDTO patchStudentRequestDTO);

}
