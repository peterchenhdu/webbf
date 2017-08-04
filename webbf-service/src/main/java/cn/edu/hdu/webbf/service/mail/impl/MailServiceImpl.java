package cn.edu.hdu.webbf.service.mail.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import cn.edu.hdu.webbf.common.log.Logger;
import cn.edu.hdu.webbf.service.mail.IMailService;
import freemarker.template.Configuration;

@Service("mailService")
public class MailServiceImpl implements IMailService
{

    protected Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    Configuration freemarkerConfiguration;

    @Override
    public void sendEmail(Object obj)
    {

        MimeMessagePreparator preparator = getMessagePreparator(obj);

        try
        {
            mailSender.send(preparator);
            logger.info("mail send sesuccss.");
        }
        catch (MailException ex)
        {
            logger.error(ex.getMessage(), ex);
        }
    }

    private MimeMessagePreparator getMessagePreparator(final Object obj)
    {

        MimeMessagePreparator preparator = new MimeMessagePreparator()
        {

            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception
            {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                helper.setFrom("928651551@qq.com");
                helper.setTo("928651551@qq.com");
                helper.setSubject("mail test.");
                Map<String, Object> model = new HashMap<String, Object>();
                model.put("user", obj);
                String text = geFreeMarkerTemplateContent(model);//Use Freemarker
                helper.setText(text, true);
                helper.addAttachment("userdel.png", new ClassPathResource("imgs/userdel.png"));
            }
        };
        return preparator;
    }

    public String geFreeMarkerTemplateContent(Map<String, Object> model)
    {
        StringBuffer content = new StringBuffer();
        try
        {
            content.append(FreeMarkerTemplateUtils.processTemplateIntoString(
                freemarkerConfiguration.getTemplate("fm_userDeleted.txt"), model));
            return content.toString();
        }
        catch (Exception e)
        {
            logger.error("Exception occured while processing fmtemplate:" + e.getMessage(), e);
        }
        return "";
    }

}