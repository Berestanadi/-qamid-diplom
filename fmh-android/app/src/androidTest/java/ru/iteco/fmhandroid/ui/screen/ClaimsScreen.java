package ru.iteco.fmhandroid.ui.screen;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.allOf;

import static ru.iteco.fmhandroid.ui.activity.MainHelper.childAtPosition;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ClaimsScreen {

    //ClaimsScreen

    public static ViewInteraction titleOfBlockClaims = onView(withText("Claims"));
    public static ViewInteraction filterClaimsButton = onView(withId(R.id.filters_material_button));
    public static ViewInteraction addNewClaim = onView(withId(R.id.add_new_claim_material_button));


    //Filter Claims

    public static ViewInteraction titleOfFilterWindow = onView((withId(R.id.claim_filter_dialog_title)));
    public static ViewInteraction executedStatus = onView(withId(R.id.item_filter_executed));
    public static ViewInteraction cancelledStatus = onView(withId(R.id.item_filter_cancelled));
    public static ViewInteraction inProgressStatus =onView(withId(R.id.item_filter_in_progress));
    public static ViewInteraction openStatus = onView(withId(R.id.item_filter_open));
    public static ViewInteraction okFilterButton = onView(withId(R.id.claim_list_filter_ok_material_button));
    public static ViewInteraction cancelFilterButton = onView(withId(R.id.claim_filter_cancel_material_button));

    //Add New Claim

    public static ViewInteraction titleOfCreationClaimWindow = onView(withId(R.id.custom_app_bar_title_text_view));
    public static ViewInteraction subTitleOfCreationClaimWindow = onView(withId(R.id.custom_app_bar_sub_title_text_view));
    public static ViewInteraction titleOfNewClaim = onView(withId(R.id.title_edit_text));
    public static ViewInteraction executorInput = onView(withId(R.id.executor_drop_menu_auto_complete_text_view));
    public static ViewInteraction executorDropDownMenu = onView(withContentDescription("Show dropdown menu"));
    public static ViewInteraction descriptionCreationClaim = onView(withId(R.id.description_edit_text));
    public static ViewInteraction dateCreationClaim = onView(withId(R.id.date_in_plan_text_input_edit_text));
    public static ViewInteraction timeCreationClaim = onView(withId(R.id.time_in_plan_text_input_edit_text));
    public static ViewInteraction okClaimButton = onView(withId(android.R.id.button1));
    public static ViewInteraction cancelClaimButton = onView(withId(android.R.id.button2));
    public static ViewInteraction saveOfClaimButton = onView(withId(R.id.save_button));
    public static ViewInteraction cancelOfClaimButton = onView(withId(R.id.cancel_button));

    //Open Claim

    public static ViewInteraction titleOfClaim = onView(withId(R.id.title_text_view));
    public static ViewInteraction executorOfClaim = onView(withId(R.id.executor_name_text_view));
    public static ViewInteraction planeDateOfClaim = onView(withId(R.id.plane_date_text_view));
    public static ViewInteraction planTimeOfClaim = onView( withId(R.id.plan_time_text_view));
    public static ViewInteraction statusOfClaim = onView(withId(R.id.status_label_text_view));
    public static ViewInteraction authorOfClaim = onView(withId(R.id.author_name_text_view));
    public static ViewInteraction dateOfCreation = onView(withId(R.id.create_data_text_view));
    public static ViewInteraction timeOfCreation = onView( withId(R.id.create_time_text_view));
    public static ViewInteraction addCommentButton = onView(withId(R.id.add_comment_image_button));
    public static ViewInteraction commentField = onView(allOf(childAtPosition(
                            childAtPosition(withId(R.id.comment_text_input_layout), 0), 0)));
    public static ViewInteraction changeStatusOfClaim = onView(withId(R.id.status_processing_image_button));
    public static ViewInteraction backToAllClaims = onView(withId(R.id.close_image_button));
}
