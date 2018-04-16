package controller;

import entity.SchoolMatch;
import entity.SchoolMatchFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;

@Named(value = "controller")
@SessionScoped
public class Controller implements Serializable {

    @EJB
    private SchoolMatchFacade schoolMatchFacade;

    @Inject
    private SchoolMatch schoolMatch;

    public SchoolMatch getSchoolMatch() {
        if (schoolMatchFacade.findCurrentMatch().isEmpty() || schoolMatchFacade.findCurrentMatch().get(0) == null) {
//            flushMatch();
//        schoolMatch.setId(null);
            return schoolMatch;
        }
        schoolMatch = schoolMatchFacade.findCurrentMatch().get(0);
        return schoolMatch;

    }

    public void flushMatch() {
        schoolMatch.setScore1(BigInteger.ZERO);
        schoolMatch.setScore2(BigInteger.ZERO);
        schoolMatch.setTeam1(null);
        schoolMatch.setTeam2(null);
        schoolMatch.setStatus(0);
    }

    public List<SchoolMatch> getCurrentSchoolMatch() {
        schoolMatch = schoolMatchFacade.findCurrentMatch().get(0);
        return schoolMatchFacade.findCurrentMatch();
    }

    public String editMatch(SchoolMatch schoolMatch) {
        this.schoolMatch = schoolMatch;
        return "edit?faces-redirect=true";
    }

    public void editMatch() {
        schoolMatchFacade.edit(schoolMatch);
    }

    public String closeMatch() {
        schoolMatch.setStatus(0);
        schoolMatchFacade.edit(schoolMatch);
        flushMatch();
        return "start?faces-redirect=true";
    }

    public String startMatch() {
        schoolMatch.setId(null);
        schoolMatch.setStatus(1);
        schoolMatch.setScore1(BigInteger.ZERO);
        schoolMatch.setScore2(BigInteger.ZERO);
        schoolMatchFacade.create(schoolMatch);
        return "edit?faces-redirect=true";
    }

}
