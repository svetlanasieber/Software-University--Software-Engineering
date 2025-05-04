using System;
using NUnit.Framework;

namespace SocialMediaManager.Tests;

public class InfluencerRepostoryTests
{
    private InfluencerRepository influencerRepository;

    [SetUp]
    public void Setup()
    {
        influencerRepository = new();
    }

    [Test]
    public void NewInflencerRepository_ShouldInitializeInfluencersCollectionCorrectly()
    {
        Assert.NotNull(influencerRepository.Influencers);
        Assert.AreEqual(0, influencerRepository.Influencers.Count);
    }

    [Test]
    public void RegisterInfluencer_ShouldThrowArgumentNullException_WhenInfluencerIsNull()
    {
        Assert.Throws<ArgumentNullException>(() => _ = influencerRepository.RegisterInfluencer(null));
    }

    [Test]
    public void RegisterInfluencer_ShouldThrowInvalidOperationException_WhenInfluencerAlreadyRegistered()
    {
        Influencer influencer = new("GoShow", 123);

        _ = influencerRepository.RegisterInfluencer(influencer);

        Assert.Throws<InvalidOperationException>(() => _ = influencerRepository.RegisterInfluencer(influencer));
    }

    [Test]
    public void RegisterInfluencer_ValidData_ReturnsMessage()
    {
        Influencer influencer = new("GoShow", 123);

        string message = influencerRepository.RegisterInfluencer(influencer);

        Assert.AreEqual($"Successfully added influencer {influencer.Username} with {influencer.Followers}", message);
        Assert.AreEqual(1, influencerRepository.Influencers.Count);
    }

    [TestCase(null)]
    [TestCase("")]
    [TestCase(" ")]
    [TestCase("     ")]
    public void RemoveInfluencer_ShouldThrowArgumentNullException_WhenUserNameIsNullOrWhiteSpace(string name)
    {
        Assert.Throws<ArgumentNullException>(() => _ = influencerRepository.RemoveInfluencer(name));
    }

    [Test]
    public void RemoveInfluencer_ExistingInfluencer_ShouldReturnTrue()
    {
        Influencer influencer = new("GoShow", 123);

        _ = influencerRepository.RegisterInfluencer(influencer);

        bool removed = influencerRepository.RemoveInfluencer(influencer.Username);

        Assert.IsTrue(removed);
    }

    [Test]
    public void RemoveInfluencer_UnexistingInfluencer_ShouldReturnFalse()
    {
        Influencer influencer = new("GoShow", 123);

        bool removed = influencerRepository.RemoveInfluencer(influencer.Username);

        Assert.IsFalse(removed);
    }

    [Test]
    public void GetInfluencerWithMostFollowers_ShouldWorkCorrectly()
    {
        Influencer ivan = new("Ivan", 123);
        Influencer goshow = new("GoShow", 125);
        Influencer asen = new("Asen", 12);

        _ = influencerRepository.RegisterInfluencer(ivan);
        _ = influencerRepository.RegisterInfluencer(goshow);
        _ = influencerRepository.RegisterInfluencer(asen);

        Influencer actual = influencerRepository.GetInfluencerWithMostFollowers();

        Assert.AreEqual(goshow.Username, actual.Username);
        Assert.AreEqual(goshow.Followers, actual.Followers);
    }

    [Test]
    public void GetInfluencer_WhenFound_ShouldReturnCorrectInfluencer()
    {
        Influencer expected = new("GoShow", 123);

        _ = influencerRepository.RegisterInfluencer(expected);

        Influencer actual = influencerRepository.GetInfluencer(expected.Username);

        Assert.AreEqual(expected.Username, actual.Username);
        Assert.AreEqual(expected.Followers, actual.Followers);
    }

    [Test]
    public void GetInfluencer_WhenNotFound_ShouldReturnNull()
    {
        Influencer expected = new("GoShow", 123);

        Influencer actual = influencerRepository.GetInfluencer(expected.Username);

        Assert.Null(actual);
    }
}