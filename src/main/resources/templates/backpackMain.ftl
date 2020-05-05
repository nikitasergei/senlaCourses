<#import "parts/pageTemplate.ftl" as pt>
<@pt.page>
    <div class="container mt-5" style="width: 50%">
        <h1>BackPack App</h1>

        <div class="form-group mt-3">
            <form action="/sixthTask" method="post">
                <div class="form-group">
                    <div class="form-group" style="border: 1px solid gray; padding: 30px">
                        <#if itemsSet??><h3>You need to take:</h3><#else><h3>Item List</h3></#if>
                        <div class="form-group">
                            <table class="table">
                                <thead class="thead-light">
                                <tr class="table-active" align="center">
                                    <th scope="col">Item's name</th>
                                    <th scope="col">Item's price</th>
                                    <th scope="col">Item's weight</th>
                                </tr>
                                <#if Items??>
                                    <#list Items as item>
                                        <tr>
                                            <td align="center">${item.name}</td>
                                            <td align="center">${item.cost}</td>
                                            <td align="center">${item.weight}</td>
                                        </tr>
                                    </#list>
                                <#else>
                                    <#list items as item>
                                        <tr>
                                            <td align="center">${item.name}</td>
                                            <td align="center">${item.cost}</td>
                                            <td align="center">${item.weight}</td>
                                        </tr>
                                    <#else>
                                        <p style="color: #c80201">
                                            Items list is empty
                                        </p>
                                    </#list>
                                </#if>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="length">Capacity</label>
                    <input type="text" style="width: 500px" name="capacity">
                </div>
                <#if itemsSet??>
                    <div class="form-group">
                        <label for="length">Result price: ${itemsSet.sumCost}</label>
                    </div>
                    <div class="form-group">
                        <label for="length">Result weight: ${itemsSet.sumWeight}</label>
                    </div>
                </#if>
                <div class="form-group mt-2">
                    <input type="submit" class="btn btn-primary" value="Serv">
                </div>
            </form>
            <a href="/addItem">
                <button type="button" class="btn btn-primary">Add item</button>
            </a>
        </div>
        <#if message??>
            <div class="alert alert-${messageType}" role="alert">
                ${message}
            </div>
        </#if>
    </div>

</@pt.page>