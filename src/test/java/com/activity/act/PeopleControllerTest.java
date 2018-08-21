package com.activity.act;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PeopleControllerTest {
    @Test
    public void get_returnsNotEmptyString() {
        String s = new PeopleController(new PeopleDAO()).get();
        assertThat(s.isEmpty()).isFalse();
    }

    @Test
    public void getPeople_listOfPeopleFromDAO() {/*
        PeopleDAO pplDAO = Mockito.mock(PeopleDAO.class);
        List<Person> mockPeople = Mockito.mock(List.class);
        when(pplDAO.getAllPeople()).thenReturn(mockPeople);

        List<Person> people = new PeopleController(pplDAO).getPeople();

        verify(pplDAO, times(1)).getAllPeople();
        verifyZeroInteractions(mockPeople);
        assertThat(people).isEqualTo(mockPeople);*/
    }
}