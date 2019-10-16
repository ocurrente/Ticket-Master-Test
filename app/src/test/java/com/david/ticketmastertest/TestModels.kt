package com.david.ticketmastertest

import com.david.ticketmastertest.models.*

class TestModels {

    companion object {
        fun getAttraction(
            name: String = "name",
            type: String = "type"
        ): Attractions {
            return Attractions(
                id = "9oiaosidi98923is3i",
                name = name,
                type = type,
                test = true,
                url = "url",
                locale = "locale",
                externalLinks = getExternalLinks(),
                aliases = null,
                images = emptyList(),
                classifications = emptyList(),
                upcomingEvents = getUpcomingEvents(),
                _links = getLinks()
            )
        }

        fun getExternalLinks(): ExternalLinks {
            return ExternalLinks(
                youtube = emptyList(),
                twitter = emptyList(),
                itunes = emptyList(),
                lastfm = emptyList(),
                facebook = emptyList(),
                wiki = emptyList(),
                instagram = emptyList(),
                musicbrainz = emptyList(),
                homepage = emptyList()
            )
        }

        fun getUpcomingEvents(): UpcomingEvents {
            return UpcomingEvents(
                _total = 0
            )
        }

        fun getLinks(): Links {
            return Links(
                self = getSelf()
            )
        }

        fun getSelf(): Self {
            return Self(
                href = "reference"
            )
        }
    }
}