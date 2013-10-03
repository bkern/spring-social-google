import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.google.api.contacts.Contact;
import org.springframework.social.google.api.contacts.ContactEntry;
import org.springframework.social.google.api.contacts.EmailContact;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class ContactsTemplateTest extends AbstractGoogleApiTest {

    @Test
    public void getContactList(){
        mockServer.expect(requestTo("https://www.google.com/m8/feeds/contacts/default/full?alt=json&max-results=9999"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("contactList"), MediaType.APPLICATION_JSON));

        Contact contact = google.contactOperations().getContacts();

        assertNotNull(contact);
        assertEquals("1.0", contact.getVersion());
        assertEquals("UTF-8",contact.getEncoding());
        assertEquals("bskern@gmail.com",contact.getFeed().getId().get$t());
        assertEquals("\"R3c7cTVSLit7I2A9WhRVFEsNQQc.\"",contact.getFeed().getEntry().get(0).getGd$etag());

        for(ContactEntry contactEntry :contact.getFeed().getEntry()){
            if(contactEntry.getGd$email() != null &&
                    contactEntry.getGd$email().size() > 0){
                for(EmailContact emailContact:contactEntry.getGd$email()){
                    assertNotNull(emailContact.getAddress());
                }

            }
        }

    }
}
