package de.jonashackt.springbootvuejs.controller;

import de.jonashackt.springbootvuejs.domain.Late;
import de.jonashackt.springbootvuejs.domain.User;
import de.jonashackt.springbootvuejs.exception.UserNotFoundException;
import de.jonashackt.springbootvuejs.repository.LateRepository;
import de.jonashackt.springbootvuejs.repository.UserRepository;
import de.jonashackt.springbootvuejs.service.LateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController()
@RequestMapping("/api")
public class BackendController {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";
    public static final String SECURED_TEXT = "Hello from the secured resource!";

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LateRepository lateRepository;

    @Autowired
    private LateService lateService;

    @RequestMapping(path = "/hello")
    public String sayHello() {
        LOG.info("GET called on /hello resource");
        return HELLO_TEXT;
    }

    @RequestMapping(path = "/user/{lastName}/{firstName}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public long addNewUser (@PathVariable("lastName") String lastName, @PathVariable("firstName") String firstName) {
        User savedUser = userRepository.save(new User(firstName, lastName));

        LOG.info(savedUser.toString() + " successfully saved into DB");

        return savedUser.getId();
    }

    @GetMapping(path = "/user/{id}")
    public User getUserById(@PathVariable("id") long id) {

        return userRepository.findById(id).map(user -> {
            LOG.info("Reading user with id " + id + " from database.");
            return user;
        }).orElseThrow(() -> new UserNotFoundException("The user with the id " + id + " couldn't be found in the database."));
    }

    @RequestMapping(path="/secured", method = RequestMethod.GET)
    public @ResponseBody String getSecured() {
        LOG.info("GET successfully called on /secured resource");
        return SECURED_TEXT;
    }

    // Forwards all routes to FrontEnd except: '/', '/index.html', '/api', '/api/**'
    // Required because of 'mode: history' usage in frontend routing, see README for further details
    @RequestMapping(value = "{_:^(?!index\\.html|api).*$}")
    public String redirectApi() {
        LOG.info("URL entered directly into the Browser, so we need to redirect...");
        return "forward:/";
    }

    @RequestMapping(path="/lates", method = RequestMethod.GET)
    public List<Late> getLates()  {
        return lateRepository.findAllByOrderByDateAsc();
    }

    @RequestMapping(path="/lates", method = RequestMethod.DELETE)
    public void deleteLates()  {
        lateRepository.deleteAll();
    }

    @RequestMapping(path="/genLates", method = RequestMethod.GET)
    public void genLates()  {
        initLateGen();
    }

    @RequestMapping(path="/lates", method = RequestMethod.POST)
    public Late create(@RequestBody @Valid Late late)  {
        return lateService.create(late);
    }

    private void initLateGen() {
        Late late = new Late();
        Late late2 = new Late();
        Late late3 = new Late();
        late.setName("marci");
        late2.setName("zulcsi");
        late3.setName("ropi");
        late.setMinutes(20L);
        late3.setMinutes(10L);
        late.setDate(LocalDate.now());
        late2.setDate(LocalDate.now().plusYears(1L));
        late3.setDate(LocalDate.now().minusYears(2L));
        lateRepository.save(late);
        lateRepository.save(late2);
        lateRepository.save(late3);
    }

    @RequestMapping(path="/stats", method = RequestMethod.GET)
    public List<Late> getStats()  {
        return lateRepository.getStatList();
    }

}
