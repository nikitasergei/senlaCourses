<#import "parts/pageTemplate.ftl" as pt>
<@pt.page>
    <div class="container mt-5" style="width: 50%">
        <h1>Add Item</h1>

        <div class="form-group mt-3">
            <form action="addItem" method="post">
                <div class="form-group">
                    <input type="text" style="width: 500px" name="name"
                           value="" placeholder="Please enter Item's name">
                </div>
                <div class="form-group">
                    <input type="text" style="width: 500px" name="weight"
                           value="" placeholder="Please enter Item's weight">
                </div>
                <div class="form-group">
                    <input type="text" style="width: 500px" name="cost"
                           value="" placeholder="Please enter Item's cost">
                </div>
                <div class="form-group mt-2">
                    <input type="submit" class="btn btn-primary" value="Save">
                </div>
            </form>
            <button type="button"
                    class="btn btn-dark"><a href="sixthTask">Back to backpack App</a>
            </button>
        </div>
        <#if message??>
            <div class="alert alert-${messageType}" role="alert">
                ${message}
            </div>
        </#if>
    </div>

</@pt.page>