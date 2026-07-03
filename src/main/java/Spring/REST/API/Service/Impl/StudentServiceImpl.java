package Spring.REST.API.Service.Impl;

import Spring.REST.API.DTO.AddStudentRequestDTO;
import Spring.REST.API.DTO.PatchStudentRequestDTO;
import Spring.REST.API.DTO.StudentDTO;
import Spring.REST.API.Entity.StudentEntity;
import Spring.REST.API.Repository.StudentRepository;
import Spring.REST.API.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<StudentEntity> students = studentRepository.findAll();
        return students.stream().map(student -> modelMapper.map(student, StudentDTO.class)).toList();
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        StudentEntity student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + id));
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public StudentDTO createNewStudent(AddStudentRequestDTO addStudentRequestDTO) {
        StudentEntity newStudent = modelMapper.map(addStudentRequestDTO, StudentEntity.class);
        StudentEntity student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student does not exist by Id: " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDTO updateStudent(Long id, AddStudentRequestDTO addStudentRequestDTO) {
        StudentEntity student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + id));
        modelMapper.map(addStudentRequestDTO, student);
        student =  studentRepository.save(student);
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public StudentDTO updatePartialStudent(Long id, PatchStudentRequestDTO patchStudentRequestDTO) {
        StudentEntity student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + id));
        if (patchStudentRequestDTO.getName() != null) {
            student.setName(patchStudentRequestDTO.getName());
        }

        if (patchStudentRequestDTO.getEmail() != null) {
            student.setEmail(patchStudentRequestDTO.getEmail());
        }
        StudentEntity saveStudent = studentRepository.save(student);
        return modelMapper.map(saveStudent, StudentDTO.class);
    }
}










