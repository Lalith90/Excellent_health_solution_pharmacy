package lk.excellent.pharamacy_management.asset.employee.controller;


import lk.excellent.pharamacy_management.asset.commonAsset.Enum.Gender;
import lk.excellent.pharamacy_management.asset.commonAsset.Enum.Title;
import lk.excellent.pharamacy_management.asset.employee.entity.Employee;
import lk.excellent.pharamacy_management.asset.employee.entity.Enum.CivilStatus;
import lk.excellent.pharamacy_management.asset.employee.entity.Enum.Designation;
import lk.excellent.pharamacy_management.asset.employee.entity.Enum.EmployeeStatus;
import lk.excellent.pharamacy_management.asset.employee.service.EmployeeService;
import lk.excellent.pharamacy_management.security.entity.Role;
import lk.excellent.pharamacy_management.security.entity.User;
import lk.excellent.pharamacy_management.security.service.RoleService;
import lk.excellent.pharamacy_management.security.service.UserService;
import lk.excellent.pharamacy_management.util.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/select")
public class EmployeeCtrl {
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmailService emailService;

    private final PasswordEncoder passwordEncoder;

    public EmployeeCtrl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/create")
    public User saveEmployee(){
        Employee employee = new Employee();
        employee.setName("Dilun");
        employee.setCallingName("Defwrgwrgwrg");
        employee.setAddress("wrgwrwrwe");
        employee.setCivilStatus(CivilStatus.MARRIED);
        employee.setDateOfBirth(LocalDate.now());
        employee.setDesignation(Designation.ADMIN);
        employee.setGender(Gender.MALE);
        employee.setEmail("dilunp4@gmail.com");
        employee.setEmployeeStatus(EmployeeStatus.WORKING);
        employee.setLand("0112879346");
        employee.setMobile("0772928483");
        employee.setNumber("E0001");
        employee.setNic("933390268V");
        employee.setTitle(Title.MR);
        employee.setDoassignment(LocalDate.now());

        List<Role> set = new ArrayList<>();
        Role role = new Role();
        role.setRoleName("MANAGER");
        set.add(role);


        User user = new User();
        user.setEmployee(employee);


        user.setRoles(set);
        user.setEnabled(true);
        user.setUsername("Dilun");
        user.setPassword("12345");
        userService.persist(user);

        return userService.findById(1);
    }

    @GetMapping(value = "/emp" , produces = "application/json")
    public void sendOne(){
        Employee employee = employeeService.findById(1);
        System.out.println(employee);

    }
@GetMapping("/email")
    public void sendEmail(){
        String email = "keerthinuwan12345@gmail.com";
        String subjec = "kelaweyan ";
        String message = " nuwan enawo  ";
        emailService.sendEmployeeRegistrationEmail(email,subjec,message);
}
}
