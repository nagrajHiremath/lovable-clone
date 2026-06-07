package com.codingshuttle.lovableclone.entity;

import com.codingshuttle.lovableclone.entity.enums.MessageRole;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "chat_message")
public class ChatMessage {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "project_id", referencedColumnName = "project_id"),
            @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    })
    ChatSession chatSession;

    String content;

    @Enumerated(EnumType.STRING)
    MessageRole messageRole;
    Integer tokensUsed;

    @CreationTimestamp
    Instant createdAt;
}
