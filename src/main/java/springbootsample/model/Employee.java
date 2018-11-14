package springbootsample.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "employee")
public class Employee {
    @Id
    private long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime createTime;

    @Enumerated(EnumType.STRING)
    @Column(length = 9)
    private Role role;

    @Converter(autoApply = true)
    public static class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

        @Override
        public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
            return attribute == null ? null : Timestamp.valueOf(attribute);
        }

        @Override
        public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
            return dbData == null ? null : dbData.toLocalDateTime();
        }
    }
}