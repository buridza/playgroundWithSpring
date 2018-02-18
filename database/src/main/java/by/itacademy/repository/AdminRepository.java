package by.itacademy.repository;

import by.itacademy.entity.account.admin.Admin;
import by.itacademy.entity.account.admin.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminRepository extends CrudRepository<Admin, Long> {
    List<Admin> findAdminsByRole(Role role);
}
