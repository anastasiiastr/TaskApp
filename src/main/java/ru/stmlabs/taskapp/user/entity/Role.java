package ru.stmlabs.taskapp.user.entity;

import ru.stmlabs.taskapp.user.util.UserRolesEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;

@Getter
@Setter
@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
public class Role  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column
    @Enumerated
    private UserRolesEnum roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Role role)) return false;

        return new EqualsBuilder().append(userId, role.userId).append(roles, role.roles).isEquals();
    }
}
