// Include form validation functions here
function validate() {
    var title = document.forms["edit-form"]["Title"].value;
    var gross = document.forms["edit-form"]["gross"].value;
    var DOL = document.forms["edit-form"]["DOL"].value;
    var category = document.forms["edit-form"]["category"].value;

    if(title === "") {
        alert("Title is required");
        return false;
    }
    else if(title.length < 2 || title.length > 65) {
        alert("Title should have 2 to 65 characters");
        return false;
    }
    else if(gross === "") {
        alert("Gross is required");
        return false;
    }
    else if(isNaN(gross)) {
        alert("Gross has to be a number");
        return false;
    }
    else if(DOL === "") {
        alert("Date of Launch is required");
        return false;
    }
    else if(category === "category") {
        alert("Select one category");
        return false;
    }

}
