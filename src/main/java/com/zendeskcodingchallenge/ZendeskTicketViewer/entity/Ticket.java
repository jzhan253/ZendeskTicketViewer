package com.zendeskcodingchallenge.ZendeskTicketViewer.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class Ticket {
    @JsonProperty("allow_attachments")
    boolean allowAttachments;
    @JsonProperty("allow_channelback")
    boolean allowChannelBack;
    @JsonProperty("assignee_id")
    long assigneeId;
    @JsonProperty("brand_id")
    long brandId;
    @JsonProperty("collaborator_ids")
    long[] collaboratorIds;
    @JsonProperty("collaborators")
    Object[] collaborators;
    @JsonProperty("created_at")
    Date createdAt;
    @JsonProperty("custom_fields")
    Object customFields;
    @JsonProperty("description")
    String description;
    @JsonProperty("due_at")
    String dueAt;
    @JsonProperty("email_cc_ids")
    String[] emailCCIds;
    @JsonProperty("external_id")
    String externalId;
    @JsonProperty("follower_ids")
    long[] followerIds;
    @JsonProperty("followup_ids")
    long[] followupIds;
    @JsonProperty("forum_topic_id")
    long forumTopicId;
    @JsonProperty("group_id")
    long groupId;
    @JsonProperty("has_incidents")
    boolean hasIncidents;
    @JsonProperty("id")
    long id;
    @JsonProperty("is_public")
    boolean isPublic;
    @JsonProperty("macro_ids")
    long[] macroIds;
    @JsonProperty("organization_id")
    long organizationId;
    @JsonProperty("priority")
    String priority;
    @JsonProperty("problem_id")
    long problemId;
    @JsonProperty("raw_subject")
    String rawSubject;
    @JsonProperty("recipient")
    String recipient;
    @JsonProperty("requester_id")
    long requesterId;
    @JsonProperty("satisfaction_rating")
    Object satisfactionRating;
    @JsonProperty("sharing_agreement_ids")
    long[] sharingAgreementIds;
    @JsonProperty("status")
    String status;
    @JsonProperty("subject")
    String subject;
    @JsonProperty("submitter_id")
    long submitterId;
    @JsonProperty("tags")
    List<String> tags;
    @JsonProperty("ticket_form_id")
    long ticketFormId;
    @JsonProperty("type")
    String type;
    @JsonProperty("updated_at")
    String updatedAt;
    @JsonProperty("url")
    String url;
    // For API - ticket endpoints this is not important
    @JsonProperty("via")
    Object via;
    @JsonProperty("via_followup_source_id")
    long viaFollowupSourceId;
//    boolean open;
//    Date created_at;
}
