package com.mikuac.bot.plugins.aop;

import com.mikuac.bot.common.utils.RegexUtils;
import com.mikuac.bot.common.utils.SendMsgUtils;
import com.mikuac.bot.config.Global;
import com.mikuac.bot.config.RegexConst;
import lombok.SneakyThrows;
import net.lz1998.pbbot.bot.Bot;
import net.lz1998.pbbot.bot.BotPlugin;
import net.lz1998.pbbot.utils.Msg;
import onebot.OnebotEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 推送至所有群
 *
 * @author Zero
 * @date 2020/11/18 16:58
 */
@Component
public class SendAllGroup extends BotPlugin {

    private SendMsgUtils sendMsgUtils;

    @Autowired
    public void setSendMsgUtils(SendMsgUtils sendMsgUtils) {
        this.sendMsgUtils = sendMsgUtils;
    }

    @SneakyThrows
    @Override
    public int onPrivateMessage(@NotNull Bot bot, @NotNull OnebotEvent.PrivateMessageEvent event) {
        long userId = event.getUserId();
        String msg = event.getRawMessage();
        if (userId == Global.bot_adminId && msg.matches(RegexConst.SEND_ALL_GROUP)) {
            List<Long> groupIdList = sendMsgUtils.getGroupList();
            String regMsg = RegexUtils.regex(RegexConst.GET_SEND_ALL_GROUP_MSG, msg);
            if (groupIdList != null && !groupIdList.isEmpty() && regMsg != null) {
                for (long groupId : groupIdList) {
                    sendMsgUtils.sendGroupMsg(groupId, Msg.builder().text(regMsg));
                }
            }
        }
        return MESSAGE_IGNORE;
    }

}