<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-30
  Time: 오후 3:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>HIGG</title>

    <link href="/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="/css/bootstrap/offcanvas.css" rel="stylesheet">

    <style>
        img {
            width: 40px;
            height: 40px;
        }

        progress {
            width: 100px;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.1.js"
            integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <%--   <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
               integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
               crossorigin="anonymous"></script>
   --%>

</head>
<body class="bg-light">

<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
    <a class="navbar-brand mr-auto mr-lg-0" href="/higg/main">HIGG</a>
    <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
        </ul>
        <form class="form-inline my-2 my-lg-0" method="post" action="/higg/main">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" name="searchName">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>


<main role="main" class="container">

    <div class="d-flex align-items-center p-3 my-3 text-white-50 bg-primary rounded box-shadow">
        <img class="mr-3"
             src="http://ddragon.leagueoflegends.com/cdn/12.22.1/img/profileicon/${summonerDTO.profileIconId}.png"
             alt="" width="48" height="48">

        <div class="lh-100">
            <h6 class="mb-0 text-white lh-100">${summonerDTO.name}</h6>
            <small>${summonerDTO.summonerLevel}</small>
        </div>

        <c:if test="${soloRankEntryDTO ne null}">
            <div class="lh-100">
                <img src="/image/ranked-emblems/Emblem_${soloRankEntryDTO.tier}.png">
                <small>SOLO RANK
                    : ${soloRankEntryDTO.tier} ${soloRankEntryDTO.rank} ${soloRankEntryDTO.leaguePoints}p</small>
                <small>${soloRankEntryDTO.wins}승 / ${soloRankEntryDTO.losses}패 </small>
            </div>
        </c:if>
        <c:if test="${teamRankEntryDTO ne null}">
            <div class="lh-100">
                <img src="/image/ranked-emblems/Emblem_${teamRankEntryDTO.tier}.png">
                <small>TEAM RANK
                    : ${teamRankEntryDTO.tier} ${teamRankEntryDTO.rank} ${teamRankEntryDTO.leaguePoints}p</small>
                <small>${teamRankEntryDTO.wins}승 / ${teamRankEntryDTO.losses}패 </small>
            </div>
        </c:if>

    </div>
    <br><br><br>

    <c:forEach var="matchDTO" items="${matchDTO}">

        <c:if test="${matchDTO.info.queueId == 420}">
            <span class="badge bg-light">솔랭</span>
        </c:if>

        <c:if test="${matchDTO.info.queueId == 430}">
            <span class="badge bg-light">일반</span>
        </c:if>

        <c:if test="${matchDTO.info.queueId == 440}">
            <span class="badge bg-light">팀랭</span>
        </c:if>

        <c:if test="${matchDTO.info.queueId == 450}">
            <span class="badge bg-light">칼바람</span>
        </c:if>

        <table class="table table-sm table-secondary table-bordered text-center table-striped">
            <thead>
            <th>승패</th>
            <th>닉네임</th>
            <th>챔피언</th>
            <th>스펠</th>
            <th>k/d/a</th>
            <th>아이템</th>
            <th>총 딜량</th>
            <th>획득한 골드</th>
            </thead>
            <c:forEach var="participants" items="${matchDTO.info.participants}" varStatus="loop">

                <c:if test="${loop.count > 5}">
                    <tr style="background-color: #fff1f3">
                </c:if>
                <c:if test="${loop.count <= 5}">
                    <tr style="background-color: #ecf2ff">
                </c:if>
                <td>
                    <c:if test="${participants.win}">
                        <span class="badge bg-primary">승리</span>
                    </c:if>
                    <c:if test="${!participants.win}">
                        <span class="badge bg-danger">패배</span>
                    </c:if>
                </td>
                <td>${participants.summonerName}</td>
                <td><img
                        src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/champion/${participants.championName}.png">
                    <span class="badge badge-light">lv${participants.champLevel}</span></td>
                <td>
                    <c:if test="${participants.summoner1Id == 1}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerBoost.png">
                    </c:if>
                    <c:if test="${participants.summoner1Id == 3}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerExhaust.png">
                    </c:if>
                    <c:if test="${participants.summoner1Id == 4}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerFlash.png">
                    </c:if>
                    <c:if test="${participants.summoner1Id == 6}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerHaste.png">
                    </c:if>
                    <c:if test="${participants.summoner1Id == 7}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerHeal.png">
                    </c:if>
                    <c:if test="${participants.summoner1Id == 11}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerSmite.png">
                    </c:if>
                    <c:if test="${participants.summoner1Id == 12}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerTeleport.png">
                    </c:if>
                    <c:if test="${participants.summoner1Id == 13}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerMana.png">
                    </c:if>
                    <c:if test="${participants.summoner1Id == 14}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerDot.png">
                    </c:if>
                    <c:if test="${participants.summoner1Id == 21}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerBarrier.png">
                    </c:if>
                    <c:if test="${participants.summoner1Id == 30}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerPoroRecall.png">
                    </c:if>
                    <c:if test="${participants.summoner1Id == 31}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerPoroThrow.png">
                    </c:if>
                    <c:if test="${participants.summoner1Id == 32}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerSnowball.png">
                    </c:if>
                    <c:if test="${participants.summoner1Id == 39}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerSnowURFSnowball_Mark.png">
                    </c:if>
                    <c:if test="${participants.summoner1Id == 54}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/Summoner_UltBookPlaceholder.png">
                    </c:if>
                    <c:if test="${participants.summoner1Id == 55}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/Summoner_UltBookSmitePlaceholder.png">
                    </c:if>

                    <c:if test="${participants.summoner2Id == 1}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerBoost.png">
                    </c:if>
                    <c:if test="${participants.summoner2Id == 3}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerExhaust.png">
                    </c:if>
                    <c:if test="${participants.summoner2Id == 4}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerFlash.png">
                    </c:if>
                    <c:if test="${participants.summoner2Id == 6}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerHaste.png">
                    </c:if>
                    <c:if test="${participants.summoner2Id == 7}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerHeal.png">
                    </c:if>
                    <c:if test="${participants.summoner2Id == 11}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerSmite.png">
                    </c:if>
                    <c:if test="${participants.summoner2Id == 12}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerTeleport.png">
                    </c:if>
                    <c:if test="${participants.summoner2Id == 13}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerMana.png">
                    </c:if>
                    <c:if test="${participants.summoner2Id == 14}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerDot.png">
                    </c:if>
                    <c:if test="${participants.summoner2Id == 21}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerBarrier.png">
                    </c:if>
                    <c:if test="${participants.summoner2Id == 30}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerPoroRecall.png">
                    </c:if>
                    <c:if test="${participants.summoner2Id == 31}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerPoroThrow.png">
                    </c:if>
                    <c:if test="${participants.summoner2Id == 32}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerSnowball.png">
                    </c:if>
                    <c:if test="${participants.summoner2Id == 39}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/SummonerSnowURFSnowball_Mark.png">
                    </c:if>
                    <c:if test="${participants.summoner2Id == 54}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/Summoner_UltBookPlaceholder.png">
                    </c:if>
                    <c:if test="${participants.summoner2Id == 55}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/spell/Summoner_UltBookSmitePlaceholder.png">
                    </c:if>

                </td>
                <td>
                        ${participants.kills} / ${participants.deaths} / ${participants.assists}
                    <span class="badge badge-primary">
                        <fmt:formatNumber value="${(participants.kills + participants.assists) / participants.deaths}"
                                          pattern="0.00"></fmt:formatNumber>
                    </span>
                </td>
                <td>
                    <c:if test="${participants.item0 != 0}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/item/${participants.item0}.png">
                    </c:if>
                    <c:if test="${participants.item1 != 0}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/item/${participants.item1}.png">
                    </c:if>
                    <c:if test="${participants.item2 != 0}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/item/${participants.item2}.png">
                    </c:if>
                    <c:if test="${participants.item3 != 0}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/item/${participants.item3}.png">
                    </c:if>
                    <c:if test="${participants.item4 != 0}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/item/${participants.item4}.png">
                    </c:if>
                    <c:if test="${participants.item5 != 0}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/item/${participants.item5}.png">
                    </c:if>
                    <c:if test="${participants.item6 != 0}">
                        <img src="https://ddragon.leagueoflegends.com/cdn/12.22.1/img/item/${participants.item6}.png">
                    </c:if>
                </td>

                <td>
                    <progress max="100000" value="${participants.totalDamageDealtToChampions}"></progress>
                        ${participants.totalDamageDealtToChampions}</td>
                <td>${participants.goldEarned + 500}</td>

                </tr>


            </c:forEach>
        </table>
        <br><br><br>
    </c:forEach>

    </div>
    <style>
        #text {
            position: fixed;
            right: 0px;
            top: 32px;
            width: 397px;
            height: 100%;
            overflow: auto;
        }

        #list_tr {
            font-size: 15px;
        }
    </style>


    <div class="card my-4 " id="text">
        <h5 class="card-header">댓글</h5>
        <div class="card-body">
            <div class="form-group">
                <input type="hidden" name="searchNum" value="${summonerDTO.puuid}"/>
                <input type="hidden" name="uid" value="${sessionScope.loginInfo.uid}"/>
                <textarea name="message" class="form-control" rows="4" cols="50" id="message"
                          placeholder="댓글을 입력하세요"></textarea>
            </div>
            <button type="button" class="btn btn-primary" onclick='postsubmit()'>Submit</button>
            <%-- axios.post(
     '/comment/ajaxselect', {
     puuid : '${summonerDTO.puuid}',
     uid : '${sessionScope.loginInfo.uid}',
     reply : document.querySelector('#message').value
     })"--%>
            <button type="button" onclick="getSearchList()" class="btn btn-primary">새로고침</button>

            <table class="table table-striped table-sm" id="replylist">
            </table>
        </div>
    </div>
</main>

<script>
    $(window).load(getSearchList())

    /* ajax,axios */
    function getSearchList() {
        $.ajax({
            type: 'GET',
            url: '/comment/ajaxselect/${summonerDTO.puuid}',
            success: function (data) {
                console.log(data)
                $("#replylist").html('');
                $.each(data, function (index, item) {

                    let html = '';
                    html += '<tr id="list_tr" ">';
                    html += '<td>' + item.uid + ':</td>';
                    html += '<td>' + item.reply + '</td>';
                    html += '</tr>';

                    /*$("#replylist").prepend(html);*/
                    $("#replylist").append(html);
                });

            },
            error: function () {
                alert('error');
            }
        });
    };

    function postsubmit() {
        if (document.querySelector('#message').value == "") {
            alert("댓글 입력 후 submit버튼을 눌러주세요")
            return;
        }
        axios.post('/comment/ajaxselect', {
            puuid: '${summonerDTO.puuid}',
            uid: '${sessionScope.loginInfo.uid}',
            reply: document.querySelector('#message').value
        })
            /*댓글 입력 후 새로고침 & 입력 초기화*/
            .finally(getSearchList(),
                document.querySelector('#message').value = ""
            );
    }

</script>
<script>window.jQuery || document.write('<script src="js/assets/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="js/assets/vendor/popper.min.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>
<script src="js/assets/js/vendor/holder.min.js"></script>
<script src="js/bootstrap/offcanvas.js"></script>

</body>
</html>
